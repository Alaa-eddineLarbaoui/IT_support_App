package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/panne/")
public class PanneController {

    @Autowired
    private PanneService panneService;


    @GetMapping("getAll")
    public List<Panne> getAllUsers(){
        return panneService.showAll();
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id ){
        panneService.deletePanne(id);
    }


    @PostMapping("registre")
    public Panne registerPanne(@RequestBody Panne panne){
        return  panneService.registrePanne(panne);
    }
    @PutMapping("update/{id}")
    public Panne updatePanne(@PathVariable Long id, @RequestBody Panne panne){
        return  panneService.updatePanne(id,panne);
    }



}
