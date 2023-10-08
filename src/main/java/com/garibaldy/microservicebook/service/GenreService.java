package com.garibaldy.microservicebook.service;

import java.util.List;

import com.garibaldy.microservicebook.dto.GenreDTO;
import com.garibaldy.microservicebook.request.GenreRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;

public interface GenreService {

    List<GenreDTO> findAll();

    GenreDTO findById(Long GenreId) throws ApiBravoEcxeption;

    void save(GenreRequest request);

    void delete(Long genre) throws ApiBravoEcxeption;

    GenreDTO update(GenreRequest request, Long genreId) throws ApiBravoEcxeption;

}
