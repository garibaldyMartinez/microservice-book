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

import com.garibaldy.microservicebook.config.validator.Authorvalidator;
import com.garibaldy.microservicebook.config.validator.GenreValidator;
import com.garibaldy.microservicebook.request.AuthorRequest;
import com.garibaldy.microservicebook.service.AuthorService;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/author")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;
    private Authorvalidator validator;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveGenre(@Valid @RequestBody AuthorRequest request) {
        this.validator.validate(request);
        this.authorService.save(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getGenderbyId(@PathVariable Long authorId) throws ApiBravoEcxeption {
        return new ResponseEntity<>(authorService.findById(authorId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{authorId}")
    public ResponseEntity<Object> deleteGender(@PathVariable Long authorId) throws ApiBravoEcxeption {
        this.authorService.delete(authorId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(path = "/{authorId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateGenre(@Valid @RequestBody AuthorRequest request,
            @PathVariable Long authorId) throws ApiBravoUnprocessableEntity, ApiBravoEcxeption {
        this.validator.validate(request);
        return new ResponseEntity<>(this.authorService.update(request, authorId), HttpStatus.OK);
    }

}
