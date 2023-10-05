package com.garibaldy.microservicebook.model;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "LIBROS")
@AttributeOverride(column = @Column(name = "ID_LIBRO"), name = "id")
public class Libro {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "TITULO", length = 100, nullable = false)
    private String titulo;

    @Column(name = "DESCRIPCION", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;

    @Column(name = "DISPONIBLE", nullable = false)
    private boolean disponible;

    @Column(name = "EDITORA", length = 50, nullable = false)
    private String nombreEditora;

    @Column(name = "FECHA_PUBLICACION")
    private LocalDateTime fechaPublicacion;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCracion;

    @ManyToMany
    @JoinTable(name = "LIBROS_GENEROS", joinColumns = @JoinColumn(name = "ID_LIBRO", referencedColumnName = "ID_LIBRO"), inverseJoinColumns = @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID_GENERO"))
    private Collection<Genero> generos;

    @ManyToMany
    @JoinTable(name = "LIBROS_AUTORES", joinColumns = @JoinColumn(name = "ID_LIBRO", referencedColumnName = "ID_LIBRO"), inverseJoinColumns = @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR"))
    private Collection<Autor> autores;

}
