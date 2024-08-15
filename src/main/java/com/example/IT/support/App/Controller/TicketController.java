package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Enum.EtatTicket;
import com.example.IT.support.App.Model.TicketOfSupport;
import com.example.IT.support.App.Service.TicketService;
import com.example.IT.support.App.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/ticket/")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("add_tickets")
    public ResponseEntity<TicketOfSupport> addTicket(@RequestBody TicketOfSupport supportTicket) {
        TicketOfSupport newTicket = ticketService.saveTicket(supportTicket);
        return ResponseEntity.ok(newTicket);
    }
    @GetMapping("ofUser/{userId}")
    public List<TicketOfSupport> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @GetMapping("ofTechnician/{technicianId}")
    public List<TicketOfSupport> getTicketsByTechnician(@PathVariable Long technicianId) {
        return ticketService.getTicketsByTechnician(technicianId);
    }



    @PutMapping("update/{id}")
    public TicketOfSupport updateTicketStatus(@PathVariable Long id, @RequestParam EtatTicket status) {
        return ticketService.updateTicketStatus(id, status);
    }

    @PutMapping("assign/{ticketId}/{technicianId}")
    public TicketOfSupport assignTicket(@PathVariable Long ticketId, @PathVariable Long technicianId) {
        return ticketService.assignTicket(ticketId, technicianId);
    }

    @GetMapping("allTicket")
    public List<TicketOfSupport> all_ticket (){
        return ticketService.getall();
    }
}



