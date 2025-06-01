package com.example.IT.support.App.Service;

import com.example.IT.support.App.Exceptions.PanneNotFoundException;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Repository.EquipementRepository;
import com.example.IT.support.App.Repository.PanneRepository;
import com.example.IT.support.App.Repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService {

    private final PanneRepository panneRepository;

    private final EquipementRepository equipementRepository;

    private final PersoneRepository personeRepository;

    public PanneService(PanneRepository panneRepository, EquipementRepository equipementRepository, PersoneRepository personeRepository) {
        this.panneRepository = panneRepository;
        this.equipementRepository = equipementRepository;
        this.personeRepository = personeRepository;
    }

    /**
     * Enregistrer une nouvelle panne dans la base de données.
     * @param panne L'objet Panne à enregistrer.
     * @return La panne enregistrée.
     */
    public Panne registrePanne(Panne panne) {
        // Equipement equipement = equipementRepository.findById(equipementId).orElse(null);
        // if (equipement == null) {
        //     throw new RuntimeException("Équipement non trouvé.");
        // }
        // panne.setEquipments((Set<Equipement>) equipement);

        return panneRepository.save(panne);
    }

   

    /**
     * Récupérer la liste de toutes les pannes.
     * @return Liste des pannes.
     */
    public List<Panne> showAll() {
        return panneRepository.findAll();
    }

    /**
     * Récupérer les détails d'une panne par son ID.
     * @param id L'ID de la panne.
     * @return La panne correspondante.
     * @throws PanneNotFoundException si la panne n'existe pas.
     */
    public Panne showpanne(Long id) {
        return panneRepository.findById(id)
                .orElseThrow(PanneNotFoundException::new);
    }

    /**
     * Mettre à jour une panne existante.
     * @param id L'ID de la panne à mettre à jour.
     * @param panne Les nouvelles informations de la panne.
     * @return La panne mise à jour.
     * @throws PanneNotFoundException si la panne n'existe pas.
     */
    public Panne updatePanne(Long id, Panne panne) {
        Panne existingPanne = showpanne(id);
        existingPanne.setName(panne.getName());
        return panneRepository.save(existingPanne);
    }
     /**
     * Supprimer une panne par son ID.
     * @param panneId L'ID de la panne à supprimer.
     */
    public void deletePanne(Long panneId) {
        panneRepository.deleteById(panneId);
    }
}
