package com.example.IT.support.App.Model;

import com.example.IT.support.App.Enum.EtatPanne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanne;

    @Column
    private Date complaintDate;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatPanne etatPanne;

//    @ManyToOne
//    @JoinColumn(name = "equipement_id")
//    private Equipement equipement;

    @OneToOne(mappedBy = "panne")
    private TicketOfSupport ticketOfSupport;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "panne_equipement",
            joinColumns = @JoinColumn(name = "panne_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipments = new HashSet<>();
    //private Set<Equipement> equipments = new HashSet<>();
}
