package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Entities.Sales;
import com.example.inventorymanagementbackend.Repositories.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{
    SalesRepository salesRepository;

    @Override
    public void save(double Price , Orders Order) {
        Sales sales = new Sales();
        sales.setTotalPrice(Price);
        sales.setOrders(Order);
        salesRepository.save(sales);

}

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }


}
