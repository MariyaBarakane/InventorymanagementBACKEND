package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;

import java.util.List;

public interface MedicationService {
    MEDICATION saveMedication(MEDICATION medication);
    MEDICATION getMedication(Long medicationId) throws MedicationNotFound;
    void deleteMedication(Long medicationId) throws MedicationNotFound;

    int getQuantity(long medicationid) throws MedicationNotFound;
    public List<MEDICATION> findMedication() ;


    void updateQuantity(long medicationID, int quantity) throws MedicationNotFound;
}
