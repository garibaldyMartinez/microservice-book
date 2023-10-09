package com.garibaldy.microservicebook.config.validator;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.request.BookRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoUnprocessableEntity;

@Service
public class BookValidatorImpl implements BookValidator {

    @Override
    public void validate(BookRequest request) throws ApiBravoUnprocessableEntity {

        if (Objects.isNull(request) || (request.getTitle().isEmpty()) || request.getTitle().isBlank()) {
            this.mesagge("The field Title is required");
        } else if (request.getTitle().length() < 5) {
            this.mesagge("The field Title require minumun 5 charactrs");
        }

        if ((request.getDescription().isEmpty()) || request.getDescription().isBlank()) {
            this.mesagge("The field description is required");
        } else if (request.getDescription().length() < 15) {
            this.mesagge("The field  description require 10 charactrs");
        }
        if ((request.getEditorName().isEmpty()) || request.getEditorName().isBlank()) {
            this.mesagge("The field Editor Name is required");
        } else if (request.getEditorName().length() < 7) {
            this.mesagge("The field  Editor Name require 7 charactrs");
        }
        if ((request.getQuantity() < 0)) {
            this.mesagge("The field Quantity must be greater than zero");
        }
        if ((Objects.isNull(request.getPublicatioDate()))) {
            this.mesagge("The field Publication Dateis required");
        }
        if ((request.getAuthors().isEmpty())) {
            this.mesagge("Must have at least one Author");
        }
        if ((request.getGenders().isEmpty())) {
            this.mesagge("Must have at least one Genre");
        }
    }

    private void mesagge(String message) throws ApiBravoUnprocessableEntity {
        throw new ApiBravoUnprocessableEntity(message);
    }

}
