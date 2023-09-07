package com.example.inventorymanagementbackend.Repositories;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LongSummaryStatistics;

public interface MedicationRepository extends JpaRepository<MEDICATION, Long> {



}
