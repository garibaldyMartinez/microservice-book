package com.garibaldy.microservicebook.config.validator;

import java.util.Objects;
import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.request.GenreRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;
import com.garibaldy.microservicebook.utils.helpers.MHelpers;

@Service
public class GenreValidatorInplm implements GenreValidator {

    @Override
    public void validate(GenreRequest request) throws ApiBravoUnprocessableEntity {

        if (Objects.isNull(request) || (request.getName().isEmpty()) || request.getName().isBlank()) {
            this.mesagge("The field name is required");
        } else if (request.getName().length() < 3) {
            this.mesagge("The field name require minumun 3 charactrs");
        }

        if ((request.getDescription().isEmpty()) || request.getName().isBlank()) {
            this.mesagge("The field description is required");
        } else if (request.getDescription().length() < 10) {
            this.mesagge("The field  description require 10 charactrs");
        }
        if ((request.getGenreType().isEmpty()) || request.getName().isBlank()) {
            this.mesagge("The field genreType is required");
        } else if (Objects.isNull(MHelpers.convertToGenre(request.getGenreType()))) {
            this.mesagge(
                    "The genre does not exist, be sure to type one of the following (Tale, Novel, Rehearsal, Poetry).");

        }
    }

    private void mesagge(String message) throws ApiBravoUnprocessableEntity {
        throw new ApiBravoUnprocessableEntity(message);
    }

}
