package com.example.inventorymanagementbackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Facture {
    @Id
    private long id ;

    @OneToOne
    private Orders order;
    private double montant_total ;
    private String ETAT ;

    public Facture(Orders order, double montant_total){
        this.order=order ;
        this.montant_total=montant_total;
    }

    public Facture(Facture facture){
        this.order=facture.getOrder() ;
        this.montant_total=facture.getMontant_total();
    }








}
