package com.garibaldy.microservicebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.dto.GenreDTO;
import com.garibaldy.microservicebook.model.Genre;
import com.garibaldy.microservicebook.model.repository.GenreRepository;
import com.garibaldy.microservicebook.request.GenreRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.helpers.MHelpers;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository generoRepository;

    public GenreServiceImpl(GenreRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<GenreDTO> findAll() {
        var genders = generoRepository.findAll();
        return genders.stream().map(MHelpers::convertToGenreDTO).toList();
    }

    @Override
    public GenreDTO findById(Long genreId) throws ApiBravoEcxeption {
        Optional<Genre> genre = generoRepository.findById(genreId);
        if (!genre.isPresent()) {
            throw new ApiBravoEcxeption("There is no genre with  id: " + genreId);
        }
        return MHelpers.convertToGenreDTO(generoRepository.findById(genreId).get());
    }

    @Override
    public void save(GenreRequest request) {
        var genre = MHelpers.convertToGenreRequest(request);
        genre.setGenreType(MHelpers.convertToGenre(request.getGenreType()));
        this.generoRepository.save(genre);
    }

    @Override
    public void delete(Long genreId) throws ApiBravoEcxeption {
        Optional<Genre> genreExist = generoRepository.findById(genreId);
        if (genreExist.isPresent()) {
            this.generoRepository.deleteById(genreId);
        } else {
            throw new ApiBravoEcxeption("There is no genre with  id: " + genreId);
        }

    }

    @Override
    public GenreDTO update(GenreRequest request, Long genreId) throws ApiBravoEcxeption {
        var genre = this.generoRepository.findById(genreId);
        Genre genreEdit;
        if (genre.isPresent()) {
            genreEdit = genre.get();
            MHelpers.copyPropertiesGenre(request, genreEdit);
            this.generoRepository.save(genreEdit);
        } else {
            throw new ApiBravoEcxeption("There is no genre with  id: " + genreId);
        }

        return MHelpers.convertToGenreDTO(genreEdit);
    }

}
