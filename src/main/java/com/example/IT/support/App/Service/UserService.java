package com.example.IT.support.App.Service;

import com.example.IT.support.App.Exceptions.UserNotFoundException;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des utilisateurs.
 */
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Récupère tous les utilisateurs.
     *
     * @return Liste des utilisateurs.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Récupère un utilisateur par son ID.
     *
     * @param id ID de l'utilisateur.
     * @return Utilisateur correspondant.
     */
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    /**
     * Enregistre un nouvel utilisateur.
     *
     * @param user Utilisateur à enregistrer.
     * @return Utilisateur enregistré.
     */
    public User saveUser(User user) {
        // Encodage du mot de passe avant l'enregistrement
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Supprime un utilisateur par son ID.
     *
     * @param id ID de l'utilisateur à supprimer.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Met à jour les informations d'un utilisateur.
     *
     * @param id ID de l'utilisateur à mettre à jour.
     * @param user Nouveaux détails de l'utilisateur.
     * @return Utilisateur mis à jour.
     */
    public User updateUser(Long id, User user) {
        User us = getUser(id);
        us.setUsername(user.getUsername());
        us.setEmail(user.getEmail());
        us.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(us);
    }

    /**
     * Recherche un utilisateur par son nom d'utilisateur.
     *
     * @param username Nom d'utilisateur.
     * @return Utilisateur correspondant.
     */
    public User getUserByUsername(String username) {
        // Supposant qu'il peut y avoir plusieurs utilisateurs avec le même nom
        return userRepository.findByUsername(username).get(0);
    }

    /**
     * Recherche un utilisateur unique par son nom d'utilisateur.
     *
     * @param username Nom d'utilisateur.
     * @return Utilisateur correspondant.
     */
    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    // Ajout potentiel pour l'authentification ou la gestion des rôles.
    // public User assignRoleToUser(Long userId, String roleName) {
    //     // Logique pour assigner un rôle à un utilisateur
    // }
}
