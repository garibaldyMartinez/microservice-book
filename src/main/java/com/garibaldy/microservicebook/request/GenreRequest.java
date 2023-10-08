package com.garibaldy.microservicebook.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class GenreRequest implements Serializable {

    private String name;
    private String description;
    String genreType;

}
