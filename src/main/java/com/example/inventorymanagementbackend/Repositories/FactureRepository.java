package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
