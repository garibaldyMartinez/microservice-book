package com.garibaldy.microservicebook.model;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GENEREROS")
@AttributeOverrides(column = @Column(name = "ID_GENERO"), name = "id")
public class Genero {

    @Id
    @Column(name = "ID_GENERO")
    @GeneratedValue
    private long id;

    @Column(name = "NOMBRE", length = 150, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 250)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_GENERO", length = 30, nullable = false)
    TipoGenero tipoGenero;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

}
