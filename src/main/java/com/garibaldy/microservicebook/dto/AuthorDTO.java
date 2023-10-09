package com.garibaldy.microservicebook.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuthorDTO implements Serializable {

    private long id;
    private String name;
    private String lastName;
    private String fullName;
    private String nationality;
    private LocalDate birthDay;
    private LocalDateTime createDate;

}
