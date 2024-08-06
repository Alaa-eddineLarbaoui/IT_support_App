package com.example.IT.support.App.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class TechnicienIT extends Person{
    @OneToMany(mappedBy = "technicien")
    private List<TicketOfSupport> ticketOfSupports;
}
