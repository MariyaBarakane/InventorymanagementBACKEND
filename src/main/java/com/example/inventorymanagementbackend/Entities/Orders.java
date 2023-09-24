package com.example.inventorymanagementbackend.Entities;

import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import jakarta.persistence.*;
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

    @OneToMany
    private List<OrderLines> Orderline;
}

