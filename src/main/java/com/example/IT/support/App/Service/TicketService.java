package com.example.IT.support.App.Service;

import com.example.IT.support.App.Enum.EtatTicket;
import com.example.IT.support.App.Model.Panne;
import com.example.IT.support.App.Model.TicketOfSupport;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.PanneRepository;
import com.example.IT.support.App.Repository.TicketRepository;
import com.example.IT.support.App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PanneRepository panneRepository;




    public TicketOfSupport saveTicket(TicketOfSupport ticket, Long panneId, User user) {
        Panne panne = panneRepository.findById(panneId)
                .orElseThrow(() -> new RuntimeException("Incident not found"));
        ticket.setPanne(panne);
//        ticket.setUser((Utilisateur) user);
        ticket.setEtatTicket(EtatTicket.OPEN);
        return ticketRepository.save(ticket);
    }


    public TicketOfSupport updateTicketStatus(Long id, EtatTicket ticketStatut) {
        TicketOfSupport ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setEtatTicket(ticketStatut);
        return ticketRepository.save(ticket);
    }


//    public List<TicketOfSupport> assignTicket(Long id, Long userId) {
//        TicketOfSupport ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
//        TechnicianIT technician = userRepository.findById(userId)
//                .filter(TechnicianIT.class::isInstance)
//                .map(TechnicianIT.class::cast)
//                .orElseThrow(() -> new RuntimeException("Technician not found"));
//        ticket.setTechnician(technician);
//        return Collections.singletonList(ticketRepository.save(ticket));
//    }

//    public List<TicketOfSupport> getTicketsByUser(Long userId) {
//        return ticketRepository.findByUtilisateur_Id(userId);
//    }

//    public List<TicketOfSupport> getTicketsByTechnician(Long technicianId) {
//        return ticketRepository.findByTechnicienIT(technicianId);
//    }

}






