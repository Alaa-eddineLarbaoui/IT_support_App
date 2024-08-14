package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Service.TechnicienITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Tech")
public class TechnicienController {


        @Autowired
        private TechnicienITService technicienITService;

        @PostMapping("/register")
        public TechnicienIT registerTechnicien(@RequestBody TechnicienIT technicienIT) {
            return technicienITService.registerTechnicien(technicienIT);
        }

        @GetMapping("/all")
        public List<TechnicienIT> getAllTechniciens() {
            return technicienITService.getAllTechniciens();
        }

        @GetMapping("/get/{id}")
        public TechnicienIT showTechnicienById(@PathVariable Long id) {
            return technicienITService.ShowTechnicienById(id);
        }

        @PutMapping("/update/{id}")
        public TechnicienIT updateTechnicien(@PathVariable Long id, @RequestBody TechnicienIT technicienIT) {
            return technicienITService.updateTechnicien(id, technicienIT);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteTechnicien(@PathVariable Long id) {
            technicienITService.deleteTechnicien(id);
        }
    }




