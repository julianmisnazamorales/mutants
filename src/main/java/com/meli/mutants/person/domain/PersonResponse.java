package com.meli.mutants.person.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonResponse {

    private boolean isMutant;

    private List<String> dna;

    private List<String> dnaChange;
}
