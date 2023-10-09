package com.garibaldy.microservicebook.controller;

import java.util.Optional;

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

import com.garibaldy.microservicebook.config.validator.GenreValidator;
import com.garibaldy.microservicebook.request.GenreRequest;
import com.garibaldy.microservicebook.service.GenreService;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/genre")
@AllArgsConstructor
public class GenreController {

    private GenreService generoService;
    private GenreValidator validator;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getGenders() {
        return new ResponseEntity<>(generoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveGenre(@Valid @RequestBody GenreRequest request)
            throws ApiBravoUnprocessableEntity {
        this.validator.validate(request);
        generoService.save(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{genderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getGenderbyId(@PathVariable Long genderId) throws ApiBravoEcxeption {
        return new ResponseEntity<>(generoService.findById(genderId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{genderId}")
    public ResponseEntity<Object> deleteGender(@PathVariable Long genderId) throws ApiBravoEcxeption {
        this.generoService.delete(genderId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(path = "/{genderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateGenre(@Valid @RequestBody GenreRequest request,
            @PathVariable Long genderId) throws ApiBravoUnprocessableEntity, ApiBravoEcxeption {
        this.validator.validate(request);
        return new ResponseEntity<>(this.generoService.update(request, genderId), HttpStatus.OK);
    }

}
