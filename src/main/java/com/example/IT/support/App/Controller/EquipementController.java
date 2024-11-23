package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("api/equipement/")
public class EquipementController {


    private final EquipementService equipementService;

    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public Equipement addEvenement(@RequestBody Equipement equipement){
        return equipementService.addEquipement(equipement);
    }

    @GetMapping("getAll")
    public List<Equipement> showAllEqui(){
        return equipementService.showAll();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("get/{id}")
    public Equipement getEquibyId(@PathVariable Long id){
        return equipementService.showEquipement(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public void DeleteEquipement(@PathVariable Long id ){
        equipementService.deleteEquipement(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public Equipement updateUser(@PathVariable Long id, @RequestBody Equipement equipement){
        return  equipementService.updateEqui(id,equipement);
    }

}


