package com.garibaldy.microservicebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.model.Author;
import com.garibaldy.microservicebook.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void delete(Long bookId) {
        authorRepository.deleteById(bookId);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(long authorId) {
        var author = authorRepository.findById(authorId);
        return author;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author, Long authorId) {
        var authorEdit = authorRepository.findById(authorId);
        return authorEdit.get();
    }

}
