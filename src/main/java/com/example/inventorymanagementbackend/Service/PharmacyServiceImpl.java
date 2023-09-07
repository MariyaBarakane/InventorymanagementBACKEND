package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Pharmacy;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.PharmacyNotFoundException;
import com.example.inventorymanagementbackend.Repositories.MedicationRepository;
import com.example.inventorymanagementbackend.Repositories.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService{

    PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> getAllPharmacy() {
       return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy getPharmacy(long pharmacyId) throws PharmacyNotFoundException {
        Pharmacy pharmacy  =pharmacyRepository.findById(pharmacyId)
                .orElseThrow(()->new PharmacyNotFoundException("Pharmacy not found! "));
        return pharmacy;
    }

    @Override
    public void deletePharmacy(long pharmacyId) {
        pharmacyRepository.deleteById(pharmacyId);
    }

    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }


}
