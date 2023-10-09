package com.garibaldy.microservicebook.service;

import java.util.List;

import com.garibaldy.microservicebook.dto.BookDTO;
import com.garibaldy.microservicebook.request.BookRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;

public interface BookService {

    List<BookDTO> findAll();

    BookDTO findById(long bookId) throws ApiBravoEcxeption;

    void save(BookRequest request);

    void delete(Long bookId) throws ApiBravoEcxeption;

    BookDTO update(BookRequest author, Long authorId) throws ApiBravoEcxeption;

}
