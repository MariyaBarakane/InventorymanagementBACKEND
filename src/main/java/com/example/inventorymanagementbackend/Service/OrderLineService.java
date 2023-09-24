package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.OrderLines;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;

import java.util.List;

public interface OrderLineService {


    OrderLines save(OrderLines orderLine) throws MedicationNotFound, OrderInvalidException;

    public List<OrderLines> getOrderline(Orders order);
}
