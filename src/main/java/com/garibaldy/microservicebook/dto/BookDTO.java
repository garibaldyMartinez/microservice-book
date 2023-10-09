package com.garibaldy.microservicebook.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import com.garibaldy.microservicebook.model.Author;
import com.garibaldy.microservicebook.model.Genre;

import lombok.Data;

@Data
public class BookDTO implements Serializable {

    private long id;
    private String title;
    private String description;
    private int quantity;
    private boolean available;
    private String editorName;
    private LocalDateTime publicationdate;
    private LocalDateTime createDate;
    private Collection<Genre> genders;
    private Collection<Author> authors;

}
