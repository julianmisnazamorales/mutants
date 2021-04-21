package com.meli.mutants.person.exceptions;

public class ProteinExistInDataBase extends Throwable{


    public ProteinExistInDataBase(String message){
        super();
    }

    public ProteinExistInDataBase(String message, Throwable e) {
        super(message, e);
    }
}
