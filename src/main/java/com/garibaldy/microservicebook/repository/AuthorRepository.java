package com.garibaldy.microservicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garibaldy.microservicebook.model.Author;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
    
}
