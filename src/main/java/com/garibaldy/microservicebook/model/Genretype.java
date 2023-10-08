package com.garibaldy.microservicebook.model;

public enum Genretype {

    TALE("Tale"),
    NOVEL("Novel"),
    REHEARSAL("Rehearsal"),
    POETRY("Poetry");

    String value;

    private Genretype(String value) {
        this.value = value;
    }

    public String getvalue() {
        return value;
    }
}
