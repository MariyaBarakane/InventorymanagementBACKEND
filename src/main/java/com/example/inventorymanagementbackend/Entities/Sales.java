package com.example.inventorymanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Sales {
    @Id
    private long id;
    @OneToOne
    private Facture facture;


}
