package com.garibaldy.microservicebook.utils.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiBravoNotFound extends Exception {

    public ApiBravoNotFound(String message) {
        super(message);
    }

}
