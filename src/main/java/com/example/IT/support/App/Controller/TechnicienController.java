package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Service.TechnicienITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Tech")
public class TechnicienController {

    private final TechnicienITService technicienITService;

    public TechnicienController(TechnicienITService technicienITService) {
        this.technicienITService = technicienITService;
    }

//        @PostMapping("/register")
//        public TechnicienIT registerTechnicien(@RequestBody TechnicienIT technicienIT) {
//            return technicienITService.registerTechnicien(technicienIT);
//        }

    /**
     * Récupère tous les techniciens informatiques.
     * @return Une liste de tous les techniciens informatiques.
     */
    @GetMapping("/all")
    public List<TechnicienIT> getAllTechniciens() {
        return technicienITService.getAllTechniciens();
    }

    /**
     * Affiche un technicien informatique en fonction de son identifiant.
     * @param id L'identifiant du technicien à récupérer.
     * @return Le technicien correspondant à l'id.
     */
    @GetMapping("/get/{id}")
    public TechnicienIT showTechnicienById(@PathVariable Long id) {
        return technicienITService.showTechnicienById(id);
    }

    /**
     * Met à jour les informations d'un technicien informatique existant.
     * @param id L'identifiant du technicien à mettre à jour.
     * @param technicienIT L'objet TechnicienIT contenant les nouvelles informations.
     * @return Le technicien mis à jour.
     */
    @PutMapping("/update/{id}")
    public TechnicienIT updateTechnicien(@PathVariable Long id, @RequestBody TechnicienIT technicienIT) {
        return technicienITService.updateTechnicien(id, technicienIT);
    }

    /**
     * Supprime un technicien informatique de la base de données.
     * @param id L'identifiant du technicien à supprimer.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
        technicienITService.deleteTechnicien(id);
    }
}
