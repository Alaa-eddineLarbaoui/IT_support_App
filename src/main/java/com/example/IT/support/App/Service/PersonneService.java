package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Admin;
import com.example.IT.support.App.Model.Person;
import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.dto.SingUpDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service pour la gestion des personnes (Users, Admins, Techniciens IT).
 */
@Service
@AllArgsConstructor
public class PersonneService {

    @Autowired
    private PersoneRepository personeRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Enregistre une nouvelle personne en fonction de son rôle.
     *
     * @param request DTO contenant les informations d'inscription.
     * @return Un message indiquant le succès de l'inscription.
     */
    public String register(SingUpDto request) {
        // Créer une entité Person en fonction du rôle spécifié dans la requête.
        Person person = createUserByRole(request);

        // Sauvegarder la personne dans le repository.
        personeRepository.save(person);

        return "person signup";
    }

    /**
     * Crée une entité Person adaptée au rôle spécifié.
     *
     * @param request DTO contenant les informations d'inscription.
     * @return Une instance de la classe Person appropriée (Admin, TechnicienIT, User).
     */
    private Person createUserByRole(SingUpDto request) {
        // Encoder le mot de passe avant de l'enregistrer.
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Utilisation d'un switch pour déterminer le rôle et créer l'instance correspondante.
        Person person = switch (request.getRole()) {
            case ADMIN -> new Admin();
            case TECHNICIEN -> new TechnicienIT();
            default -> new User();
        };

        // Configurer les propriétés communes à tous les rôles.
        person.setUsername(request.getUsername());
        person.setEmail(request.getEmail());
        person.setPassword(encodedPassword);
        person.setRole(request.getRole());

        return person;
    }
}
