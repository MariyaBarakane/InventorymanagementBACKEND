package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {

  List<Orders> findBymedicationId(Long medicationID);
}
