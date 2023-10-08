package com.garibaldy.microservicebook.utils.helpers;

import org.modelmapper.ModelMapper;

import com.garibaldy.microservicebook.dto.GenreDTO;
import com.garibaldy.microservicebook.model.Genre;
import com.garibaldy.microservicebook.model.Genretype;
import com.garibaldy.microservicebook.request.GenreRequest;

public class MHelpers {

    private static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // This method is responsible for converting an object of type Entity to DTO
    public static GenreDTO convertToGenreDTO(final Genre genre) {
        return modelMapper().map(genre, GenreDTO.class);
    }

    // This method is responsible for converting an object of type DTO to Entity
    public static Genre convertToGenre(final GenreDTO genre) {
        return modelMapper().map(genre, Genre.class);
    }

    // This method is responsible for converting an object of type Request to Entity
    public static Genre convertToGenreRequest(final GenreRequest request) {
        return modelMapper().map(request, Genre.class);
    }

    public static Genre copyPropertiesGenre(GenreRequest request, Genre genre){
       genre.setName(request.getName()); 
       genre.setDescription(request.getDescription());
       genre.setGenreType(convertToGenre(request.getGenreType()));
       return genre;
    }

    public static Genretype convertToGenre(String description) {
        switch (description) {
            case "Tale":
                return Genretype.TALE;
            case "Novel":
                return Genretype.NOVEL;
            case "Rehearsal":
                return Genretype.REHEARSAL;
            case "Poetry":
                return Genretype.POETRY;
            default:
                return null;
        }
    }

}