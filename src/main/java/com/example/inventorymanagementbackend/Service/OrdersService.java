package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;

import java.util.List;

public interface OrdersService {

    List<Orders> getAllorders();

    Orders saveOrder(Orders Order) throws MedicationNotFound, OrderInvalidException;



}
