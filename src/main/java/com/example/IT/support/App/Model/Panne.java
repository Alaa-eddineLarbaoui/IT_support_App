package com.example.IT.support.App.Model;

import com.example.IT.support.App.Enum.EtatPanne;
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
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanne;
    private Date complaintDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatPanne etatPanne;



}
