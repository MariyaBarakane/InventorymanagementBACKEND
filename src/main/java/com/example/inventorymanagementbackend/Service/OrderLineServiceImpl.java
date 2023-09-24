package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.OrderLines;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;
import com.example.inventorymanagementbackend.Repositories.OrderLineRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor @NoArgsConstructor @Data
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;
    @Autowired
    MedicationService medicationService;

    @Override
    public OrderLines save(OrderLines orderLine) throws MedicationNotFound, OrderInvalidException {
        if (orderLine.getQuantity() <= medicationService.getQuantity(orderLine.getMedication().getId())){
           MEDICATION medi = orderLine.getMedication();
           medicationService.updateQuantity(medi.getId(), orderLine.getQuantity());
             return orderLineRepository.save(orderLine);
    }
        throw new OrderInvalidException("Impossible de passer la commande.Quantité non dispo! ");
}

    @Override
    public List<OrderLines> getOrderline(Orders order) {
       return orderLineRepository.findOrderLineByOrder(order);
    }
}
