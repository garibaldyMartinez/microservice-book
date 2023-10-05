package com.garibaldy.microservicebook.model;

public enum TipoGenero {

    CUENTO("Cuento"),
    NOVELA("Novela"),
    NOVELA_CORTA("Novela Corta"),
    ENSAYO("Ensayo"),
    POESIA("Poesia");

    String value;

    private TipoGenero(String value) {
        this.value = value;
    }

    public String getvalue() {
        return value;
    }
}
