package com.garibaldy.microservicebook.service;

import java.util.List;
import java.util.Optional;

import com.garibaldy.microservicebook.model.Author;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(long authorId);

    Author save(Author author);

    void delete(Long authorId);

    Author update(Author author, Long authorId);

}
