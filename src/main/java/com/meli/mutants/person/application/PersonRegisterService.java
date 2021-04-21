package com.meli.mutants.person.application;

import com.meli.mutants.person.domain.PersonResponse;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;

public interface PersonRegisterService {

    void registerPerson(PersonResponse personResponse) throws ProteinExistInDataBase;
}
