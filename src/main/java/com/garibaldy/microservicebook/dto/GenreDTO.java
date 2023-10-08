package com.garibaldy.microservicebook.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GenreDTO implements Serializable {

    private long id;
    private String name;
    private String description;
    String genreType;
    private LocalDateTime createDate;

}
