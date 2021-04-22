package com.meli.mutants.mutant.application;

import com.meli.mutants.person.application.PersonRegisterService;
import com.meli.mutants.person.domain.PersonResponse;
import com.meli.mutants.person.domain.Proteins;
import com.meli.mutants.person.exceptions.LengthProteinWrong;
import com.meli.mutants.person.exceptions.NotContainProtein;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class MutantValidatorServiceImpl implements MutantValidatorService {

    @Value("${valid.protein.length}")
    private int validLength;

    @Value("${valid.mutant.protein.length}")
    private int validLengthMutant;

    private final PersonRegisterService personRegisterService;

    public MutantValidatorServiceImpl(PersonRegisterService personRegisterService){
        this.personRegisterService = personRegisterService;
    }

    @Override
    public PersonResponse isMutant(List<String> dna) throws NotContainProtein, LengthProteinWrong, ProteinExistInDataBase {
        validateProteins(dna);
        PersonResponse personResponse = generateSequence(dna);
        Set<Boolean> set = new HashSet<>();
        dna.forEach( atp -> {
            String [] proteins = atp.split("");
            boolean result = Arrays.asList(proteins).stream().collect(LinkedList<List<String>>::new, (list, value) -> {
                if (list.isEmpty() || !list.getLast().get(0).equals(value))
                {
                    list.add(new ArrayList<>());
                }
                list.getLast().add(value);
                }, (list1, list2) -> {
                if (list1.getLast().get(0).equals(list2.getFirst().get(0)))
                {
                    list1.getLast().addAll(list2.getFirst());
                    list2.removeFirst();
                }
                list1.addAll(list2);
            }).stream().anyMatch ( x -> x.size() >= validLengthMutant );
            set.add(result);
        });
        personResponse.setMutant(set.size() == 2);
        personRegisterService.registerPerson(personResponse);
        return personResponse;
    }


    /**
     * Pivot and generate a list of proteins from the original string dna list
     * @param dna
     *        String from client
     * @return
     *        Object person built with the list params of dna
     */
    private PersonResponse generateSequence(List<String> dna){
        PersonResponse personResponse = new PersonResponse();
        List<String> data = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        int cont = 0;
        for (String rna : dna) {
            for (int i = 0; i < dna.size() ; i++) {
                String value = dna.get(i).split("")[cont];
                string.append(value);
                if(string.length() == validLength){
                    data.add(string.toString());
                    string = new StringBuilder();
                    cont ++;
                }
            }
        }
        personResponse.setDna(dna);
        personResponse.setDnaChange(data);
        return personResponse;
    }

    /**
     * Validate the protein in the list of parameters
     * @param dna
     * @return
     */
    private void validateProteins(List<String> dna) throws LengthProteinWrong, NotContainProtein {
        boolean containProteinInList = true;
        for (String stringProtein: dna) {            
            List<String> eachValueList = Arrays.asList(stringProtein.split(""));
            for (String value : eachValueList) {
                if(!Arrays.stream(Proteins.values()).anyMatch( x -> x.getNick().equals(value))){
                    containProteinInList = false;
                }
            }
        }
        if(!containProteinInList){
            log.error("Your proteins are wrong: {}", dna.toString());
            throw new NotContainProtein("Your proteins are wrong", new NotContainProtein("Your proteins are wrong" + dna.toString()));
        }
    }
}
