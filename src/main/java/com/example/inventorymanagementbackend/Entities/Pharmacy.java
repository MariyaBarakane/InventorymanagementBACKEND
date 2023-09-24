package com.example.inventorymanagementbackend.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String Address;


}
