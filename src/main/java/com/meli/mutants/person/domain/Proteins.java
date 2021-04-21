package com.meli.mutants.person.domain;

public enum Proteins {

    ADENINE("A"),
    GUANINE("G"),
    CYTOSINE("C"),
    THYMINE("T");

    private String nick;

    Proteins(String nick){
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }
}
