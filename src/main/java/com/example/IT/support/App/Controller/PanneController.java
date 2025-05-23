package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/panne/")
public class PanneController {

    private final PanneService panneService;

    public PanneController(PanneService panneService) {
        this.panneService = panneService;
    }


    @GetMapping("getAll")
    public List<Panne> getAllUsers(){
        return panneService.showAll();
    }
    @PreAuthorize("hasRole('ADMIN')")

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id ){
        panneService.deletePanne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public Panne registerPanne(@RequestBody Panne panne){
        return  panneService.registrePanne(panne);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public Panne updatePanne(@PathVariable Long id, @RequestBody Panne panne){
        return  panneService.updatePanne(id,panne);
    }



}
