package com.garibaldy.microservicebook.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "GENEREROS", uniqueConstraints = { @UniqueConstraint(columnNames = { "NOMBRE", "TIPO_GENERO" }) })
@AttributeOverride(column = @Column(name = "ID_GENERO"), name = "id")
public class Genre {

    @Id
    @Column(name = "ID_GENERO")
    @GeneratedValue
    private long id;

    @Column(name = "NOMBRE", length = 150, nullable = false)
    private String name;

    @Column(name = "DESCRIPCION", length = 250)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_GENERO", length = 30, nullable = false)
    Genretype genreType;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime createDate;

    @ManyToMany(mappedBy = "genders")
    private List<Book> books;

    @PrePersist
    public void persist() {
        this.createDate = LocalDateTime.now();
    }

}
