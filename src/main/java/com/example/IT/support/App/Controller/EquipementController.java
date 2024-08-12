package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("api/equipement/")
public class EquipementController {


    @Autowired
    private EquipementService equipementService;

    @PostMapping("add")
    public Equipement addEvenement(@RequestBody Equipement equipement){
        return equipementService.AddEquipement(equipement);
    }

    @GetMapping("getAll")
    public List<Equipement> ShowAllEqui(){
        return equipementService.ShowAll();

    }
    @GetMapping("get/{id}")
    public Equipement GetUserById(@PathVariable Long id){
        return equipementService.ShowEquipement(id);
    }

    @DeleteMapping("delete/{id}")
    public void DeleteEquipement(@PathVariable Long id ){
        equipementService.DeleteEquipement(id);
    }

    @PutMapping("update/{id}")
    public Equipement updateUser(@PathVariable Long id, @RequestBody Equipement equipement){
        return  equipementService.UpdateEqui(id,equipement);
    }

}


