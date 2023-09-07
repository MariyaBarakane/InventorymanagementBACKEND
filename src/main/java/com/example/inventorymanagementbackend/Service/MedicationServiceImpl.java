package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Repositories.MedicationRepository;
import com.example.inventorymanagementbackend.Repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationServiceImpl implements MedicationService{

    @Autowired

    private MedicationRepository medicationRepository;
    private OrderRepository orderRepository;

    @Override
    public  List<MEDICATION> findMedication() {
        return medicationRepository.findAll();
    }

    @Override
    public MEDICATION saveMedication(MEDICATION medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public MEDICATION getMedication(Long medicationId) throws MedicationNotFound {
        MEDICATION medication =medicationRepository.findById(medicationId)
                .orElseThrow(()->new MedicationNotFound("Medication not found! "));
        return medication;
    }

    @Override
    public void deleteMedication(Long medicationId)throws MedicationNotFound  {
        medicationRepository.deleteById(medicationId);

    }

    @Override
    public List<Orders> Trackmedication(Long medicationId) {
        return orderRepository.findBymedicationId(medicationId) ;
    }

    @Override
    public int getQuantity(long medicationId) throws MedicationNotFound {

        MEDICATION medication =medicationRepository.findById(medicationId)
                .orElseThrow(()->new MedicationNotFound("Medication not found! "));
        return medication.getQuantity();
    }

    @Override

    public void updateQuantity(MEDICATION medication) throws MedicationNotFound {
        int quantity =getMedication(medication.getId()).getQuantity();
        getMedication(medication.getId()).setQuantity(quantity-medication.getQuantity());
    }
}
