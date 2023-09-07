package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
}
