package com.example.IT.support.App.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("USER")
public class User extends Person{


    @OneToMany
    private  List<Panne> pannes;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<TicketOfSupport> ticketOfSupports;

    @OneToMany
    private List<Equipement> equipements;



}
