package com.example.mysqlmongodb.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTEMENTS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_ID")
    private Integer id;
    @Column(name = "_TITRE")
    private String titre;
}
