package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Repository.EquipementRepository;
import com.example.IT.support.App.Repository.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanneService {
    @Autowired
    private PanneRepository panneRepository;
    @Autowired
    private EquipementRepository equipementRepository;




    public Panne enregistrerPanne(Long equipementId, Panne panne) {
        Equipement equipement = equipementRepository.findById(equipementId).orElse(null);
        if (equipement == null) {
            throw new RuntimeException("Équipement non trouvé.");
        }
        panne.setEquipement(equipement);
        return panneRepository.save(panne);
    }
}
