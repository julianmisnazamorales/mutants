package com.meli.mutants.person.exceptions;

public class LengthProteinWrong extends Throwable {


    public LengthProteinWrong(String message) {
        super();
    }

    public LengthProteinWrong(String message, Throwable e) {
        super(message, e);
    }
}