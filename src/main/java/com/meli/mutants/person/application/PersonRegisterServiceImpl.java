package com.meli.mutants.person.application;

import com.meli.mutants.person.domain.Person;
import com.meli.mutants.person.domain.PersonResponse;
import com.meli.mutants.person.domain.PersonRepository;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonRegisterServiceImpl implements PersonRegisterService{

    private PersonRepository personRepository;

    public PersonRegisterServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public void registerPerson(PersonResponse personResponse) throws ProteinExistInDataBase {
        Person person = new Person();
        person.setMutant(personResponse.isMutant());
        StringBuilder dnaString = new StringBuilder();
        personResponse.getDna().forEach( x -> dnaString.append(x).append(","));
        String dna = dnaString.substring(0, dnaString.length() -1);
        Person existPerson = findByDna(dna);
        if(existPerson == null){
            person.setDna(dna);
            personRepository.save(person);
        }
        else{
            throw new ProteinExistInDataBase("The protein string is already in db", new ProteinExistInDataBase("The protein string is already in db"));
        }
    }

    public Person findByDna(String dna){
        return personRepository.findByDna(dna);
    }



}
