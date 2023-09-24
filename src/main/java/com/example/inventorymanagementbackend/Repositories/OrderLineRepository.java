package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.OrderLines;
import com.example.inventorymanagementbackend.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLines,Long> {

    List<OrderLines> findOrderLineByOrder(Orders Order);
}
