package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Exceptions.EquipementNotFoundException;
import com.example.IT.support.App.Repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    /**
     * Ajouter un nouvel équipement dans la base de données.
     * @param equipement L'équipement à ajouter.
     * @return L'équipement ajouté.
     */
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    /**
     * Supprimer un équipement par son ID.
     * @param equipementId L'ID de l'équipement à supprimer.
     * @throws EquipementNotFoundException si l'équipement n'existe pas.
     */
    public void deleteEquipement(Long equipementId) {
        var equipement = equipementRepository.findById(equipementId)
                .orElseThrow(EquipementNotFoundException::new);
        equipementRepository.delete(equipement);
    }

    /**
     * Récupérer la liste de tous les équipements.
     * @return Liste des équipements.
     */
    public List<Equipement> showAll() {
        return equipementRepository.findAll();
    }

    /**
     * Récupérer les détails d'un équipement par son ID.
     * @param equipementId L'ID de l'équipement.
     * @return L'équipement correspondant.
     * @throws EquipementNotFoundException si l'équipement n'existe pas.
     */
    public Equipement showEquipement(Long equipementId) {
        return equipementRepository.findById(equipementId)
                .orElseThrow(EquipementNotFoundException::new);
    }

    /**
     * Mettre à jour les détails d'un équipement existant.
     * @param equipementId L'ID de l'équipement à mettre à jour.
     * @param equipement Les nouvelles informations de l'équipement.
     * @return L'équipement mis à jour.
     * @throws EquipementNotFoundException si l'équipement n'existe pas.
     */
    public Equipement updateEqui(Long equipementId, Equipement equipement) {
        Equipement existingEquipement = showEquipement(equipementId);
        existingEquipement.setName(equipement.getName());
        existingEquipement.setType(equipement.getType());
        existingEquipement.setStatus(equipement.getStatus());
        existingEquipement.setPurchase_Date(equipement.getPurchase_Date());
        existingEquipement.setDescription(equipement.getDescription());
        return equipementRepository.save(existingEquipement);
    }
}
