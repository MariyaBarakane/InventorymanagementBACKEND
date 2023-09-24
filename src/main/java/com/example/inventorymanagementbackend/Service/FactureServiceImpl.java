package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Facture;
import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Entities.Sales;
import com.example.inventorymanagementbackend.Exceptions.FactureNotFound;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

@Autowired
    FactureRepository factureRepository;


    SalesService salesService;

    @Override
    public Facture save(Orders order, double montant) {
       Facture facture = new Facture(order, montant);
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> findfactures() {
        return factureRepository.findAll();
    }

    @Override
    public void UpdateState(long facture_id, String etat) throws FactureNotFound {
      Facture facture=  factureRepository.findById(facture_id)
                .orElseThrow(()->new FactureNotFound("Facture not found! "));
      facture.setETAT(etat);

    }


}
