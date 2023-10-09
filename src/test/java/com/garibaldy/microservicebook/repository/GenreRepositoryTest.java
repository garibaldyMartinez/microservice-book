package com.garibaldy.microservicebook.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.garibaldy.microservicebook.model.Genre;
import com.garibaldy.microservicebook.model.Genretype;

@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;
    Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre(1, "Horror", "Horror Novel.", Genretype.NOVEL, LocalDateTime.now());
        genreRepository.save(genre);
    }

    @AfterEach
    void tearDown() {
        genre = null;
        genreRepository.deleteAll();
    }

    // Test case Succes
    // @Test
    void testFindByGenreId() {
        Optional<Genre> genreExist = genreRepository.findById(1L);
        assertNotNull(genreExist);
        assertEquals(genreExist.get().getId(), genre.getId());
        assertEquals(genreExist.get().getName(), genre.getName());
        assertEquals(genreExist.get().getDescription(), genre.getDescription());
        assertEquals(genreExist.get().getGenreType(), genre.getGenreType());
    }

    // Test case Fail

}
