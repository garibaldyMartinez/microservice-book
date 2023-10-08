package com.garibaldy.microservicebook.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garibaldy.microservicebook.model.Author;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
    
}
