package com.meli.mutants;

import com.meli.mutants.mutant.application.MutantValidatorServiceImpl;
import com.meli.mutants.person.exceptions.LengthProteinWrong;
import com.meli.mutants.person.exceptions.NotContainProtein;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class MutantValidatorServiceTest {

    @InjectMocks
    MutantValidatorServiceImpl service;

    private final String[] proteinsMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    private final String[] proteinsHuman = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    private final String[] proteinsWrong = {"FFGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    private final String[] proteinsWrongLength = {"ATGC","CAGTGC","TTIIGT","AGAAGG","CCCCTA","TCACTG"};

    /*
    @Test
    public void when_a_person_is_mutant() throws NotContainProtein, LengthProteinWrong {
        Person person = service.isMutant(Arrays.asList(proteinsMutant));
        assertThat(person.isMutant()).isSameAs(true);
    }

    @Test
    public void when_a_person_is_human() throws NotContainProtein, LengthProteinWrong {
        Person person = service.isMutant(Arrays.asList(proteinsHuman));
        assertThat(person.isMutant()).isSameAs(false);
    }
     */

    @Test(expected = LengthProteinWrong.class)
    public void when_a_protein_string_is_wrong() throws NotContainProtein, LengthProteinWrong, ProteinExistInDataBase {
        service.isMutant(Arrays.asList(proteinsWrong));
    }

    @Test(expected = LengthProteinWrong.class)
    public void when_a_protein_length_is_wrong() throws NotContainProtein, LengthProteinWrong, ProteinExistInDataBase {
        service.isMutant(Arrays.asList(proteinsWrongLength));
    }

}
