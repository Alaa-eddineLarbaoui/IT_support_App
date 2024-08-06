package com.example.IT.support.App.Model;

import com.example.IT.support.App.Enum.EtatTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketOfSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Ticket;
    private Date creation_date;
    private String description;

    @Enumerated(EnumType.STRING)
    private EtatTicket etatTicket;



}
