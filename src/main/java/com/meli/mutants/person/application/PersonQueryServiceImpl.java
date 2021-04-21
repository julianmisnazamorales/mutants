package com.meli.mutants.person.application;

import com.meli.mutants.person.domain.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonQueryServiceImpl implements PersonQueryService{

    public final PersonRepository personRepository;

    public PersonQueryServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public String countHumansOrMutants() {
        log.info("method countHumansOrMutants in class {} :", this.getClass().getName());
        StringBuilder response = new StringBuilder();
        Integer mutants = personRepository.countPersonByMutantIs(true);
        Integer humans = personRepository.countPersonByMutantIs(false);
        Double ratio = mutants.doubleValue()/10D;
        response.append("count_mutant_dna :").append(mutants).append(" count_human_dna :")
                .append(humans).append(" ratio ").append( ratio );
        return response.toString();
    }
}
