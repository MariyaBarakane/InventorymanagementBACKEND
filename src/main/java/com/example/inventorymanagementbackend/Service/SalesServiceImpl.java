package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Entities.Sales;
import com.example.inventorymanagementbackend.Repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{
    @Autowired
    SalesRepository salesRepository;

    @Override
    public void save(Sales sale) {
     salesRepository.save(sale);

}

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }


}
