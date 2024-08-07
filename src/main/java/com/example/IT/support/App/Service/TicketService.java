package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.PanneRepository;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private PanneRepository panneRepository;








}
