package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les utilisateurs.
 * Fournit des endpoints pour obtenir, créer, mettre à jour et supprimer des utilisateurs.
 */
@RestController // Définit cette classe comme un contrôleur REST
@CrossOrigin("*") // Permet les requêtes CORS depuis n'importe quelle origine
@RequestMapping("api/user/") // Spécifie le chemin de base pour les API utilisateurs
public class UserController {

    /**
     * Service pour gérer la logique métier des utilisateurs.
     */
    // Injection automatique du service UserService
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Récupère tous les utilisateurs.
     * Cette méthode est accessible uniquement aux administrateurs.
     * @return La liste de tous les utilisateurs.
     */
    @PreAuthorize("hasRole('ADMIN')") // Vérifie que l'utilisateur a le rôle ADMIN
    @GetMapping("getUsers") // Endpoint pour récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userService.getAllUsers(); // Appel au service pour récupérer tous les utilisateurs
    }

    /**
     * Récupère un utilisateur par son ID.
     * Cette méthode est accessible uniquement aux administrateurs.
     * @param id L'ID de l'utilisateur à récupérer.
     * @return L'utilisateur correspondant à l'ID.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("get/{id}") // Endpoint pour récupérer un utilisateur par ID
    public User GetUserById(@PathVariable Long id) {
        return userService.getUser(id); // Appel au service pour récupérer l'utilisateur par son ID
    }

    /**
     * Supprime un utilisateur par son ID.
     * Cette méthode est accessible uniquement aux administrateurs.
     * @param id L'ID de l'utilisateur à supprimer.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}") // Endpoint pour supprimer un utilisateur par ID
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Appel au service pour supprimer l'utilisateur par son ID
    }

    /**
     * Met à jour un utilisateur existant.
     * Cette méthode est accessible uniquement aux administrateurs.
     * @param id L'ID de l'utilisateur à mettre à jour.
     * @param user L'objet utilisateur contenant les nouvelles informations.
     * @return L'utilisateur mis à jour.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}") // Endpoint pour mettre à jour un utilisateur
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user); // Appel au service pour mettre à jour un utilisateur
    }

    /**
     * Recherche un utilisateur par son nom d'utilisateur.
     * Cette méthode est accessible uniquement aux administrateurs.
     * @param name Le nom d'utilisateur à rechercher.
     * @return L'utilisateur correspondant au nom donné.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("findByName") // Endpoint pour rechercher un utilisateur par nom d'utilisateur
    public User getByName(@RequestParam String name) {
        return userService.getUserByUsername(name); // Appel au service pour récupérer l'utilisateur par son nom d'utilisateur
    }

    /**
     * Récupère un utilisateur par son nom d'utilisateur.
     * Cette méthode est accessible sans authentification (ou selon les règles définies).
     * @param username Le nom d'utilisateur à récupérer.
     * @return L'utilisateur correspondant au nom d'utilisateur.
     */
    @GetMapping("get_user/{username}") // Endpoint pour récupérer un utilisateur par son nom d'utilisateur
    public User get_user(@PathVariable String username) {
        return userService.getUser(username); // Appel au service pour récupérer l'utilisateur par son nom d'utilisateur
    }
}
