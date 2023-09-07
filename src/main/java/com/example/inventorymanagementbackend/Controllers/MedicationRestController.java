package com.example.inventorymanagementbackend.Controllers;

import com.example.inventorymanagementbackend.Entities.MEDICATION;
import com.example.inventorymanagementbackend.Entities.Orders;
import com.example.inventorymanagementbackend.Entities.Pharmacy;
import com.example.inventorymanagementbackend.Exceptions.MedicationNotFound;
import com.example.inventorymanagementbackend.Exceptions.OrderInvalidException;
import com.example.inventorymanagementbackend.Service.MedicationService;
import com.example.inventorymanagementbackend.Service.OrdersService;
import com.example.inventorymanagementbackend.Service.PharmacyService;
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
public class MedicationRestController {

    @Autowired
    private MedicationService merdicationservice ;
    @Autowired
    private OrdersService ordersService;

    private PharmacyService pharmacyService;
    @GetMapping("/medication")
    public List<MEDICATION> medication(){
        return merdicationservice.findMedication();
    }
    @GetMapping("/medication/{id}")
    public MEDICATION getMedicament(@PathVariable(name = "id") Long medicamentId) throws MedicationNotFound {
        return merdicationservice.getMedication(medicamentId);
    }

    @PostMapping("/savemedication")
    public MEDICATION saveMedication(@RequestBody MEDICATION MEDICATION){
        return merdicationservice.saveMedication(MEDICATION);
    }
    @PostMapping("/savepharmacy")
    public Pharmacy savepharmacy(@RequestBody Pharmacy pharmacy){
        return pharmacyService.savePharmacy(pharmacy);
    }
    @PostMapping("/saveOrder")
    public Orders saveOrder(@RequestBody Orders Order) throws MedicationNotFound, OrderInvalidException {
        return ordersService.saveOrder(Order);
    }
}
