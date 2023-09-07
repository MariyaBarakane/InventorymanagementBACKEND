package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;
import com.example.inventorymanagementbackend.Repositories.MedicationRepository;
import com.example.inventorymanagementbackend.Repositories.OrderRepository;
import com.example.inventorymanagementbackend.Repositories.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{
    OrderRepository orderRepository;
    MedicationRepository medicationRepository;

    MedicationService medicationService;
    SalesService salesService;
    SalesRepository salesRepository;
    @Override
    public List<Orders> getAllorders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders saveOrder(Orders Order) throws MedicationNotFound , OrderInvalidException {
         List<MEDICATION> medications=Order.getMedication();
        double price=0;
        for (MEDICATION medi : medications) {
          if(medi.getQuantity()<=medicationService.getQuantity(medi.getId())){
              orderRepository.save(Order);
              medicationService.updateQuantity(medi);
              price += medi.getPrice();
              return Order;
          }
            throw new OrderInvalidException("Impossible de passer la commande.Quantité non dispo! ");
        }
        salesService.save(price,Order);
        return Order;
    }


}
