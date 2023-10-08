package com.garibaldy.microservicebook.config.validator;

import com.garibaldy.microservicebook.request.GenreRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

public interface GenreValidator {

    void validate(GenreRequest request) throws ApiBravoUnprocessableEntity;

}
