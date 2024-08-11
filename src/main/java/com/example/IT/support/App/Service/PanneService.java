package com.example.IT.support.App.Service;

import com.example.IT.support.App.Enum.EtatPanne;
import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Repository.EquipementRepository;
import com.example.IT.support.App.Repository.PanneRepository;
import com.example.IT.support.App.Repository.PersoneRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PanneService {
    @Autowired
    private PanneRepository panneRepository;
    @Autowired
    private EquipementRepository equipementRepository;
    @Autowired
    private PersoneRepository personeRepository;




    public Panne registrePanne(Panne panne) {
//        Equipement equipement = equipementRepository.findById(equipementId).orElse(null);
//        if (equipement == null) {
//            throw new RuntimeException("Équipement non trouvé.");
//        }
      // panne.setEquipments((Set<Equipement>) equipement);
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
    public Panne showpanne(Long id){
        return panneRepository.findById(id).orElseThrow();
    }

    public Panne updatePanne (Long id , Panne panne){
        Panne pn = showpanne(id);
        pn.setName(panne.getName());

        return panneRepository.save(pn);
    }



}
