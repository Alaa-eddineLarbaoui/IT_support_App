package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Exceptions.EquipementNotFoundException;
import com.example.IT.support.App.Repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;


    public Equipement addEquipement (Equipement equipement){
        return equipementRepository.save(equipement);

    }

    public void deleteEquipement (Long equipementId){
        var test = equipementRepository.findById( equipementId).get();
        equipementRepository.delete(test);

    }

    public List<Equipement> showAll(){
        return equipementRepository.findAll();
    }


    public Equipement showEquipement ( Long equipementId){
        return equipementRepository.findById(equipementId).orElseThrow(EquipementNotFoundException::new);
    }


    public Equipement updateEqui(Long equipementId,Equipement equipement){
        Equipement equip =showEquipement(equipementId);
        equip.setName(equipement.getName());
        equip.setType(equipement.getType());
        equip.setStatus(equipement.getStatus());
        equip.setPurchase_Date(equipement.getPurchase_Date());
        equip.setDescription(equipement.getDescription());

        return equipementRepository.save(equip);
    }
}
