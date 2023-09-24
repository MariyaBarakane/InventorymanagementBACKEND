package com.example.inventorymanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class MEDICATION {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id ;
    private String Name;
    private String Description ;
    private double Price ;
    private int Quantity;





}
