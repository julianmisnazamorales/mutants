package com.meli.mutants.person.exceptions;

public class NotContainProtein extends Throwable{


    public NotContainProtein(String message){
        super();
    }

    public NotContainProtein(String message, Throwable e) {
        super(message, e);
    }
}
