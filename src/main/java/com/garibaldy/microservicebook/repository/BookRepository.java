package com.garibaldy.microservicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garibaldy.microservicebook.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
