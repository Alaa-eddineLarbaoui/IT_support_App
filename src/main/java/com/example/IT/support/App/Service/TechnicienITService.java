package com.example.IT.support.App.Service;

import com.example.IT.support.App.Exceptions.TechnicienNotFoundException;
import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Repository.TechnicienITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des techniciens IT.
 */
@Service
public class TechnicienITService {

    private final TechnicienITRepository technicienITRepository;

    public TechnicienITService(TechnicienITRepository technicienITRepository) {
        this.technicienITRepository = technicienITRepository;
    }

    /**
     * Enregistrer un nouveau technicien IT dans la base de données.
     *
     * @param technicienIT L'objet TechnicienIT à enregistrer.
     * @return Le technicien IT enregistré.
     */
    public TechnicienIT registerTechnicien(TechnicienIT technicienIT) {
        return technicienITRepository.save(technicienIT);
    }

    /**
     * Récupérer la liste de tous les techniciens IT.
     *
     * @return Une liste contenant tous les techniciens IT.
     */
    public List<TechnicienIT> getAllTechniciens() {
        return technicienITRepository.findAll();
    }

    /**
     * Récupérer un technicien IT par son ID.
     *
     * @param id L'ID du technicien IT.
     * @return Le technicien IT correspondant.
     * @throws TechnicienNotFoundException si le technicien IT n'existe pas.
     */
    public TechnicienIT showTechnicienById(Long id) {
        return technicienITRepository.findById(id)
                .orElseThrow(TechnicienNotFoundException::new);
    }

    /**
     * Mettre à jour les informations d'un technicien IT existant.
     *
     * @param idTech           L'ID du technicien IT à mettre à jour.
     * @param updatedTechnicien Un objet contenant les nouvelles informations du technicien IT.
     * @return Le technicien IT mis à jour.
     */
    public TechnicienIT updateTechnicien(Long idTech, TechnicienIT updatedTechnicien) {
        // Récupérer le technicien existant
        TechnicienIT technicien = showTechnicienById(idTech);

        // Mettre à jour les champs nécessaires
        technicien.setUsername(updatedTechnicien.getUsername());
        technicien.setEmail(updatedTechnicien.getEmail());
        technicien.setPassword(updatedTechnicien.getPassword());

        // Sauvegarder les modifications
        return technicienITRepository.save(technicien);
    }

    /**
     * Supprimer un technicien IT par son ID.
     *
     * @param id L'ID du technicien IT à supprimer.
     */
    public void deleteTechnicien(Long id) {
        technicienITRepository.deleteById(id);
    }
}
