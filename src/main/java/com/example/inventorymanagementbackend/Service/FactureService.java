package com.example.inventorymanagementbackend.Service;

import com.example.inventorymanagementbackend.Entities.Facture;
import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.FactureNotFound;

import java.util.List;

public interface FactureService {


   public Facture save(Orders order , double montant);
    public List<Facture> findfactures() ;

    public void UpdateState(long facture_id , String etat) throws FactureNotFound;
}
