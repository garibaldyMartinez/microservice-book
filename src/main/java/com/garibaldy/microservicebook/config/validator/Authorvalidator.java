package com.garibaldy.microservicebook.config.validator;

import com.garibaldy.microservicebook.request.AuthorRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

public interface Authorvalidator {

    void validate(AuthorRequest request) throws ApiBravoUnprocessableEntity;

}
