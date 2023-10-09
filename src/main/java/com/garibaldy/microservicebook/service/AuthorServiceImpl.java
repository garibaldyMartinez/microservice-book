package com.garibaldy.microservicebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garibaldy.microservicebook.dto.AuthorDTO;
import com.garibaldy.microservicebook.model.Author;
import com.garibaldy.microservicebook.repository.AuthorRepository;
import com.garibaldy.microservicebook.request.AuthorRequest;
import com.garibaldy.microservicebook.utils.Exceptions.ApiBravoEcxeption;
import com.garibaldy.microservicebook.utils.helpers.MHelpers;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    private static final String ID_NOT_FOUND = "There is no author with  id: ";

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> findAll() {
        var authors = authorRepository.findAll();
        return authors.stream().map(MHelpers::convertToAuthorDTO).toList();
    }

    @Override
    public AuthorDTO findById(long authorId) throws ApiBravoEcxeption {
        Optional<Author> author = authorRepository.findById(authorId);
        if (!author.isPresent()) {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + authorId);
        }
        return MHelpers.convertToAuthorDTO(authorRepository.findById(authorId).get());
    }

    @Override
    public void save(AuthorRequest request) {
        var author = MHelpers.convertToAuthorRequest(request);
        this.authorRepository.save(author);
    }

    @Override
    public void delete(Long authorId) throws ApiBravoEcxeption {
        Optional<Author> authorExist = authorRepository.findById(authorId);
        if (authorExist.isPresent()) {
            this.authorRepository.deleteById(authorId);
        } else {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + authorId);
        }
    }

    @Override
    public AuthorDTO update(AuthorRequest request, Long authorId) throws ApiBravoEcxeption {
        var author = this.authorRepository.findById(authorId);
        Author authorEdit;
        if (author.isPresent()) {
            authorEdit = author.get();
            MHelpers.copyPropertiesAuthor(request, authorEdit);
            this.authorRepository.save(authorEdit);
        } else {
            throw new ApiBravoEcxeption(ID_NOT_FOUND + authorId);
        }

        return MHelpers.convertToAuthorDTO(authorEdit);
    }

}
