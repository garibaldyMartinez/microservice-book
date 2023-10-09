package com.garibaldy.microservicebook.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "AUTORES", uniqueConstraints = { @UniqueConstraint(columnNames = { "NOMBRE", "APELLIDO" }) })
@AttributeOverride(column = @Column(name = "ID_AUTOR"), name = "id")
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NOMBRE", length = 30, nullable = false)
    private String name;

    @Column(name = "APELLIDO", length = 30, nullable = false)
    private String lastName;

    @Column(name = "NOMBRE_COMPLETO", length = 100, nullable = false)
    private String fullName;

    @Column(name = "NACIONALIDAD", length = 50, nullable = false)
    private String nationality;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate birthDay;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime createDate;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @PrePersist
    public void persist() {
        this.createDate = LocalDateTime.now();
        this.fullName = name + " " + lastName;
    }

}
