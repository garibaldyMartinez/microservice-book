package com.garibaldy.microservicebook.service;

import java.util.List;
import com.garibaldy.microservicebook.dto.AuthorDTO;
import com.garibaldy.microservicebook.request.AuthorRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;

public interface AuthorService {

    List<AuthorDTO> findAll();

    AuthorDTO findById(long authorId) throws ApiBravoEcxeption;

    void save(AuthorRequest author);

    void delete(Long authorId) throws ApiBravoEcxeption;

    AuthorDTO update(AuthorRequest author, Long authorId) throws ApiBravoEcxeption;

}
