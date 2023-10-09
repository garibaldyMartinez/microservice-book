package com.garibaldy.microservicebook.config.validator;

import com.garibaldy.microservicebook.request.BookRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

public interface BookValidator {

    void validate(BookRequest request) throws ApiBravoUnprocessableEntity;

}
