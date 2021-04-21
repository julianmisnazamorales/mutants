package com.meli.mutants.person.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Getter
public class PersonRequest {

    @ElementCollection
    @Column(name = "dna")
    private List<String> dna;
}
