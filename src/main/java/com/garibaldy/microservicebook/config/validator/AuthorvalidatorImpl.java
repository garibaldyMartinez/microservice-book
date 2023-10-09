package com.garibaldy.microservicebook.config.validator;

import java.util.Objects;

import com.garibaldy.microservicebook.request.AuthorRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

public class AuthorvalidatorImpl implements Authorvalidator {

    @Override
    public void validate(AuthorRequest request) throws ApiBravoUnprocessableEntity {
        if (Objects.isNull(request) || (request.getName().isEmpty()) || request.getName().isBlank()) {
            this.mesagge("The field Name is required");
        } else if (request.getName().length() < 4) {
            this.mesagge("The field Name require minumun 4 charactrs");
        }

        if ((request.getLastName().isEmpty()) || request.getLastName().isBlank()) {
            this.mesagge("The field Last Name is required");
        } else if (request.getLastName().length() < 4) {
            this.mesagge("The field  Last Name require 4 charactrs");
        }
        if ((request.getNationality().isEmpty()) || request.getNationality().isBlank()) {
            this.mesagge("The field genreType is required");
        } else if (request.getNationality().length() < 5) {
            this.mesagge(
                    "The field  Nationality require 5 charactrs.");

        }
        if (Objects.isNull(request.getBirthDay())) {
            this.mesagge("The field Birth Day is required");
        }
    }

    private void mesagge(String message) throws ApiBravoUnprocessableEntity {
        throw new ApiBravoUnprocessableEntity(message);
    }

}
