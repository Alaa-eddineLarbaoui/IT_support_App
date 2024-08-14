package com.example.IT.support.App.Model;

import com.example.IT.support.App.Enum.EtatTicket;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column
    private Date creation_date;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatTicket etatTicket;


    //Relations :
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private TechnicienIT technicienIT;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;


    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;





}
