package com.garibaldy.microservicebook.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garibaldy.microservicebook.model.Author;
import com.garibaldy.microservicebook.model.Genre;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String description;
    private int quantity;
    private String editorName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publicatioDate;
    private Collection<Genre> genders;
    private Collection<Author> authors;

}
