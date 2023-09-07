package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {
}
