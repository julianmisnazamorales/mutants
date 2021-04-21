package com.meli.mutants.mutant.infraestructure;

import com.meli.mutants.mutant.application.MutantValidatorService;
import com.meli.mutants.person.application.PersonQueryService;
import com.meli.mutants.person.domain.PersonRequest;
import com.meli.mutants.person.domain.PersonResponse;
import com.meli.mutants.person.exceptions.LengthProteinWrong;
import com.meli.mutants.person.exceptions.NotContainProtein;
import com.meli.mutants.person.exceptions.ProteinExistInDataBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "MutantController", consumes = "json")
@Slf4j
@RestController
public class MutantController {

    private final MutantValidatorService serviceMutant;

    private final PersonQueryService personQueryService;

    public MutantController(MutantValidatorService serviceMutant, PersonQueryService personQueryService){
        this.serviceMutant = serviceMutant;
        this.personQueryService = personQueryService;
    }

    @ApiOperation(value = "Method to validate a mutant."
            , response = String.class, tags = "/mutant")
    @PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersonResponse> validateMutant(@RequestBody PersonRequest dna) throws NotContainProtein, LengthProteinWrong, ProteinExistInDataBase {
        log.info("method validateMutant from class {} and params {}", this.getClass().getName(), dna);
        return new ResponseEntity<>(serviceMutant.isMutant(dna.getDna()), HttpStatus.OK);
    }


    @ApiOperation(value = "Method to count type of humans according to number", response = Integer.class, tags = "/stats")
    @GetMapping("/stats")
    public ResponseEntity<String> getStats(){
        log.info("method getCountOfTypeHuman ");
        return new ResponseEntity<>(personQueryService.countHumansOrMutants(), HttpStatus.OK);
    }
}
