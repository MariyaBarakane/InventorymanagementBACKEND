package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Repositories.MedicationRepository;
import com.example.inventorymanagementbackend.Repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationServiceImpl implements MedicationService{


@Autowired
    private MedicationRepository medicationRepository;
@Autowired
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
    public int getQuantity(long medicationId) throws MedicationNotFound {

        MEDICATION medication =medicationRepository.findById(medicationId)
                .orElseThrow(()->new MedicationNotFound("Medication not found! "));
        return medication.getQuantity();
    }

    @Override

    public void updateQuantity(long medicationID, int quantity) throws MedicationNotFound {;
        MEDICATION  medi = getMedication(medicationID);
        medi.setQuantity(medi.getQuantity()-quantity);
    }
}
