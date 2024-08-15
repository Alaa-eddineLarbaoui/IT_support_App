package com.example.IT.support.App.Model;


import com.example.IT.support.App.Enum.EquipementStatus;
import com.example.IT.support.App.Enum.TypeEquipement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 225)
    private TypeEquipement type;

    @Column
    @Enumerated(EnumType.STRING)
    private EquipementStatus status;

    @Column
    private Date purchase_Date;
    @Column
    private String description;

//
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name= "userId")
//    private User user;

    @OneToMany(mappedBy = "equipement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TicketOfSupport> ticketOfSupports;


    @ManyToMany(mappedBy = "equipments")
    @JsonIgnore
    private Set<Panne> pannes = new HashSet<>();


}
