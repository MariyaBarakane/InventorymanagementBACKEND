package com.example.inventorymanagementbackend.Controllers;

import com.example.inventorymanagementbackend.Entities.Facture;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Exceptions.FactureNotFound;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;
import com.example.inventorymanagementbackend.Service.FactureServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("*")
public class FactureRestController {

    @Autowired
    FactureServiceImpl factureService;

    @PostMapping("/updatefact")
    public void updateFacture(@RequestBody long id, String message) throws FactureNotFound {
        factureService.UpdateState(id, message);
    }

    @GetMapping("/facture")
    public List<Facture> getfactures()  {
        return factureService.findfactures();
    }
}
