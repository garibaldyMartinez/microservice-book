package com.garibaldy.microservicebook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garibaldy.microservicebook.config.validator.BookValidator;
import com.garibaldy.microservicebook.request.BookRequest;
import com.garibaldy.microservicebook.service.BookService;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;
    private BookValidator validator;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveGenre(@Valid @RequestBody BookRequest request) {
        this.validator.validate(request);
        this.bookService.save(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBookbyId(@PathVariable Long bookId) throws ApiBravoEcxeption {
        return new ResponseEntity<>(bookService.findById(bookId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long bookId) throws ApiBravoEcxeption {
        this.bookService.delete(bookId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(path = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateBook(@Valid @RequestBody BookRequest request,
            @PathVariable Long bookId) throws ApiBravoUnprocessableEntity, ApiBravoEcxeption {
        this.validator.validate(request);
        return new ResponseEntity<>(this.bookService.update(request, bookId), HttpStatus.OK);
    }

}
