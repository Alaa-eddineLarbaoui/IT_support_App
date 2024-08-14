package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Model.TicketOfSupport;
import com.example.IT.support.App.Service.TicketService;
import com.example.IT.support.App.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/ticket/")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;

    @PostMapping("add_tickets")
    public ResponseEntity<TicketOfSupport> addTicket(@RequestBody TicketOfSupport supportTicket) {
        TicketOfSupport newTicket = ticketService.saveTicket(supportTicket);
        return ResponseEntity.ok(newTicket);
    }
}



