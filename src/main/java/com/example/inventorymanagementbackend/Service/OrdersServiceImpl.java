package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.*;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;
import com.example.inventorymanagementbackend.Repositories.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor @NoArgsConstructor

public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    private OrderLineServiceImpl orderLineServiceimpl;



    @Autowired
    private MedicationService medicationService;
    @Autowired
    private FactureServiceImpl factureService;

    @Override
    public List<Orders> getAllorders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders saveOrder(Orders Order) throws MedicationNotFound, OrderInvalidException {
        double Price = 0;

        for (OrderLines orderline : Order.getOrderline()) {

                Price += orderline.getQuantity() * orderline.getMedication().getPrice();


        }
        orderRepository.save(Order);
        factureService.save(Order, Price);
        return Order;

    }
}
