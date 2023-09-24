package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Entities.Sales;

import java.util.List;

public interface SalesService {

    public void save(Sales sale) ;
    public List<Sales> getAllSales();
}
