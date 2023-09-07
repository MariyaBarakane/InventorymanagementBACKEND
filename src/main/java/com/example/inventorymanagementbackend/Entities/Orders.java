package com.example.inventorymanagementbackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Orders {

    @Id
    private long id ;
    private String State;

    @OneToMany(mappedBy = "order")
    private List<MEDICATION> medication;

    @ManyToOne
    private Pharmacy pharmacy;
    @ManyToOne
    private Sales sale;
}

