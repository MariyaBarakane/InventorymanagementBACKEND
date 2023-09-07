package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Pharmacy;
import com.example.inventorymanagementbackend.Exceptions.PharmacyNotFoundException;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> getAllPharmacy();
    Pharmacy getPharmacy(long pharmacyId) throws PharmacyNotFoundException;
    void deletePharmacy(long pharmacyId);

    Pharmacy savePharmacy(Pharmacy pharmacy);
}
