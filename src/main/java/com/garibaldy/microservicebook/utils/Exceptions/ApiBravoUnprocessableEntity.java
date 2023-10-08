package com.garibaldy.microservicebook.utils.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom class to handle entity-related exceptions
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiBravoUnprocessableEntity extends RuntimeException {

    public ApiBravoUnprocessableEntity(String menssage) {
        super(menssage);
    }

}
