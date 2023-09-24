package com.example.inventorymanagementbackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLines {
    @Id
    private long id ;
    @ManyToOne
    @JoinColumn(name = "medication_id")
    private MEDICATION medication;
    @ManyToOne @JoinColumn(name = "orders_id")
    private Orders order;
    private int Quantity ;

    private double TotalPrice;
}
