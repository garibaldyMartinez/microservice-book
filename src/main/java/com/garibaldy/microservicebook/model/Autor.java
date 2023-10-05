package com.garibaldy.microservicebook.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "AUTORES")
@AttributeOverride(column = @Column(name = "ID_AUTOR"), name = "id")
public class Autor {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NOMBRE", length = 30, nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", length = 30, nullable = false)
    private String apellido;

    @Column(name = "NOMBRE_COMPLETO", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "NACIONALIDAD", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

}
