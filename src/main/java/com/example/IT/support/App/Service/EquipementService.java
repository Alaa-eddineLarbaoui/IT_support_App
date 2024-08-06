package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;


    public Equipement AddEquipement (Equipement equipement){
        return equipementRepository.save(equipement);

    }

    public void DeleteEquipement (Long equipementId){
        var test = equipementRepository.findById( equipementId).get();
        equipementRepository.delete(test);

    }

    public List<Equipement> ShowAll(){
        return equipementRepository.findAll();
    }


    public Equipement ShowEquipement ( Long equipementId){
        return equipementRepository.findById(equipementId).get();
    }


    public Equipement UpdateEqui(Long equipementId,Equipement equipement){
        Equipement equip =ShowEquipement(equipementId);
        equip.setName(equipement.getName());
        equip.setType(equipement.getType());
        equip.setStatus(equipement.getStatus());
        equip.setPurchase_Date(equipement.getPurchase_Date());
        equip.setDescription(equipement.getDescription());

        return equipementRepository.save(equip);
    }
}
