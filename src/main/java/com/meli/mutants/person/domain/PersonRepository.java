package com.meli.mutants.person.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Long> {

    Integer countPersonByMutantIs(boolean value);

    Person findByDna(String dna);
}
