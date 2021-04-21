package com.meli.mutants.mutant.application;

import com.meli.mutants.person.domain.PersonResponse;
import com.meli.mutants.person.exceptions.LengthProteinWrong;
import com.meli.mutants.person.exceptions.NotContainProtein;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;

import java.util.List;

public interface MutantValidatorService {

    /**
     * Validate a person as mutant or human
     * @param dna
     * @return
     * Person result after the validation
     * @throws NotContainProtein
     * The string contain illegal chars
     * @throws LengthProteinWrong
     * The string not contain the right length of proteins
     */
    PersonResponse isMutant(List<String> dna) throws NotContainProtein, LengthProteinWrong, ProteinExistInDataBase;

}
