package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Repository.EquipementRepository;
import com.example.IT.support.App.Repository.PanneRepository;
import com.example.IT.support.App.Repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService {
    @Autowired
    private PanneRepository panneRepository;
    @Autowired
    private EquipementRepository equipementRepository;
    @Autowired
    private PersoneRepository personeRepository;




    public Panne enregistrerPanne(Long equipementId, Panne panne) {
        Equipement equipement = equipementRepository.findById(equipementId).orElse(null);
        if (equipement == null) {
            throw new RuntimeException("Équipement non trouvé.");
        }
       //panne.setEquipments(equipement);
        return panneRepository.save(panne);
    }



    public void deletePanne(Long panneId){
         panneRepository.deleteById(panneId);

    }

    public List <Panne> showAll(){
        return panneRepository.findAll();
    }

    public Panne followStateRepair(Long panneId) {
        return panneRepository.findById(panneId).orElseThrow(() -> new RuntimeException("Failure not found."));
    }



}
