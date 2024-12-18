package com.example.IT.support.App.Service;

import com.example.IT.support.App.Enum.EtatTicket;
import com.example.IT.support.App.Model.*;
import com.example.IT.support.App.Repository.*;
import com.example.IT.support.App.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    private final UserRepository userRepository;

    private final EquipementRepository equipementRepository;

    private final PanneRepository panneRepository;

    private final TechnicienITRepository technicienITRepository;

    private final EquipementService equipementService;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, EquipementRepository equipementRepository, PanneRepository panneRepository, TechnicienITRepository technicienITRepository, EquipementService equipementService) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.equipementRepository = equipementRepository;
        this.panneRepository = panneRepository;
        this.technicienITRepository = technicienITRepository;
        this.equipementService = equipementService;
    }


//        Panne panne = panneRepository.findById(panneId)
//                .orElseThrow(() -> new RuntimeException("Incident not found"));
//        ticket.setPanne(panne);

    public TicketOfSupport saveTicket(TicketDto ticketDto) {
        Panne panne = panneRepository.findById(ticketDto.getPanne_id())
                .orElseThrow();

        Equipement equipment = equipementService.showEquipement(ticketDto.getEquipement_id());

        User user = userRepository.findById(ticketDto.getUser_id()).orElseThrow();
        TicketOfSupport ticketOfSupport = new TicketOfSupport();
        ticketOfSupport.setPanne(panne);
        ticketOfSupport.setEquipement(equipment);
        ticketOfSupport.setEtatTicket(EtatTicket.OPEN);
        ticketOfSupport.setUser(user);
        return ticketRepository.save(ticketOfSupport);
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


    public TicketOfSupport assignTicket(Long ticketId, Long technicienId) {
        TicketOfSupport ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + ticketId));

        TechnicienIT technicien = technicienITRepository.findById(technicienId)
                .orElseThrow(() -> new RuntimeException("Technician not found with id " + technicienId));

        ticket.setTechnicienIT(technicien);

        return ticketRepository.save(ticket);
    }




    public List<TicketOfSupport> getTicketsByUser(Long userId) {
        return ticketRepository.findTicketOfSupportByUser_Id(userId);
    }

    public List<TicketOfSupport> getTicketsByTechnician(Long technicianId) {
        return ticketRepository.findTicketOfSupportByTechnicienIT_Id(technicianId);
    }

    public  List<TicketOfSupport> getall(){
        return ticketRepository.findAll();
    }

}






