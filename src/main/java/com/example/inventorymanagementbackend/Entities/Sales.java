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

public class Sales {
    @Id
    private long id;
    private double TotalPrice;
@ManyToOne
  private Orders orders;
}
