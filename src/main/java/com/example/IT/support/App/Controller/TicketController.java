package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Enum.EtatTicket;
import com.example.IT.support.App.Model.TicketOfSupport;
import com.example.IT.support.App.Service.TicketService;
import com.example.IT.support.App.Service.UserService;

import com.example.IT.support.App.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les tickets de support.
 * Fournit des endpoints pour ajouter, modifier, assigner et consulter les tickets.
 */
@CrossOrigin("*") // Permet les requêtes CORS depuis n'importe quelle origine
@RestController // Définit cette classe comme un contrôleur REST
@RequestMapping("api/ticket/") // Spécifie le chemin de base pour les API des tickets
public class TicketController {

    /**
     * Service pour gérer la logique métier des tickets.
     */
    @Autowired // Injection automatique du service TicketService
    private TicketService ticketService;

    /**
     * Service pour gérer la logique métier des utilisateurs.
     */
    @Autowired // Injection automatique du service UserService
    private UserService userService;

    /**
     * Ajoute un nouveau ticket de support.
     * Cette méthode est accessible uniquement par les utilisateurs.
     * @param supportTicket L'objet TicketDto contenant les informations du ticket à ajouter.
     * @return Un message confirmant l'ajout du ticket.
     */
    @PreAuthorize("hasRole('USER')") // Vérifie que l'utilisateur a le rôle USER
    @PostMapping("add_tickets") // Endpoint pour ajouter un ticket
    public String addTicket(@RequestBody TicketDto supportTicket) {
        ticketService.saveTicket(supportTicket); // Appel au service pour enregistrer le ticket
        return "the ticket added !"; // Retourne un message de confirmation
    }

    /**
     * Récupère tous les tickets associés à un utilisateur spécifique.
     * Cette méthode est accessible sans restriction d'autorisation.
     * @param userId L'ID de l'utilisateur pour lequel récupérer les tickets.
     * @return La liste des tickets associés à l'utilisateur.
     */
    @GetMapping("ofUser/{userId}") // Endpoint pour récupérer les tickets d'un utilisateur par ID
    public List<TicketOfSupport> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId); // Appel au service pour récupérer les tickets par utilisateur
    }

    /**
     * Récupère tous les tickets assignés à un technicien spécifique.
     * Cette méthode est accessible sans restriction d'autorisation.
     * @param technicianId L'ID du technicien pour lequel récupérer les tickets.
     * @return La liste des tickets assignés au technicien.
     */
    @GetMapping("ofTechnician/{technicianId}") // Endpoint pour récupérer les tickets d'un technicien par ID
    public List<TicketOfSupport> getTicketsByTechnician(@PathVariable Long technicianId) {
        return ticketService.getTicketsByTechnician(technicianId); // Appel au service pour récupérer les tickets par technicien
    }

    /**
     * Met à jour le statut d'un ticket de support.
     * Cette méthode est accessible uniquement aux administrateurs ou selon le rôle de l'utilisateur.
     * @param id L'ID du ticket à mettre à jour.
     * @param status Le nouveau statut du ticket.
     * @return Le ticket mis à jour avec le nouveau statut.
     */
    @PutMapping("update/{id}") // Endpoint pour mettre à jour le statut d'un ticket par ID
    public TicketOfSupport updateTicketStatus(@PathVariable Long id, @RequestParam EtatTicket status) {
        return ticketService.updateTicketStatus(id, status); // Appel au service pour mettre à jour le statut du ticket
    }

    /**
     * Assigne un ticket à un technicien.
     * Cette méthode est accessible uniquement aux administrateurs ou selon le rôle de l'utilisateur.
     * @param ticketId L'ID du ticket à assigner.
     * @param technicianId L'ID du technicien auquel assigner le ticket.
     * @return Le ticket après avoir été assigné au technicien.
     */
    @PutMapping("assign/{ticketId}/{technicianId}") // Endpoint pour assigner un ticket à un technicien
    public TicketOfSupport assignTicket(@PathVariable Long ticketId, @PathVariable Long technicianId) {
        return ticketService.assignTicket(ticketId, technicianId); // Appel au service pour assigner le ticket
    }

    /**
     * Récupère tous les tickets de support.
     * Cette méthode est accessible sans restriction d'autorisation.
     * @return La liste de tous les tickets de support.
     */
    @GetMapping("allTicket") // Endpoint pour récupérer tous les tickets
    public List<TicketOfSupport> all_ticket() {
        return ticketService.getall(); // Appel au service pour récupérer tous les tickets
    }
}
