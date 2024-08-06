package com.example.IT.support.App.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

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
    @Column
    private String type;
    @Column
    private String status;
    @Column
    private Date purchase_Date;
    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name= "userId")
    private User user;


    @OneToMany(mappedBy = "equipement")
    private List<Panne> pannes;



}
