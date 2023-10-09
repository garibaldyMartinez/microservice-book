package com.garibaldy.microservicebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.dto.BookDTO;
import com.garibaldy.microservicebook.model.Book;
import com.garibaldy.microservicebook.repository.BookRepository;
import com.garibaldy.microservicebook.request.BookRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.helpers.MHelpers;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private static final String ID_NOT_FOUND = "There is no Book with  id: ";

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> findAll() {
        var books = bookRepository.findAll();
        return books.stream().map(MHelpers::convertToBookDTO).toList();
    }

    @Override
    public BookDTO findById(long bookId) throws ApiBravoEcxeption {
        Optional<Book> author = bookRepository.findById(bookId);
        if (!author.isPresent()) {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + bookId);
        }
        return MHelpers.convertToBookDTO(bookRepository.findById(bookId).get());
    }

    @Override
    public void save(BookRequest request) {
        var book = MHelpers.convertToBookRequest(request);
        this.bookRepository.save(book);
    }

    @Override
    public void delete(Long bookId) throws ApiBravoEcxeption {
        Optional<Book> bookExist = bookRepository.findById(bookId);
        if (bookExist.isPresent()) {
            this.bookRepository.deleteById(bookId);
        } else {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + bookId);
        }
    }

    @Override
    public BookDTO update(BookRequest request, Long bookId) throws ApiBravoEcxeption {
        var book = this.bookRepository.findById(bookId);
        Book bookEdit;
        if (book.isPresent()) {
            bookEdit = book.get();
            MHelpers.copyPropertiesBook(request, bookEdit);
            this.bookRepository.save(bookEdit);
        } else {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + bookId);
        }

        return MHelpers.convertToBookDTO(bookEdit);
    }

}
