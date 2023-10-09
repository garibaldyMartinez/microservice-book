package com.garibaldy.microservicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garibaldy.microservicebook.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
