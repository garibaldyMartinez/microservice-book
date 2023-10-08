package com.garibaldy.microservicebook.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garibaldy.microservicebook.model.Book;

public interface LibroRepository extends JpaRepository<Book, Long>{
    
}
