package com.meli.mutants.person.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON", length = 13)
    private Long idperson;

    @Column(name = "dna", length = 45, nullable = false)
    private String dna;

    @Column(name = "mutant")
    private boolean mutant;
}
