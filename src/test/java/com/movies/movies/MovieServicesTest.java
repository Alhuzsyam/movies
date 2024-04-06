package com.movies.movies;

// package com.movies.services;

import com.movies.models.entity.Movie;
import com.movies.models.repository.MovieRepo;
import com.movies.services.MovieServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServicesTest {

    @Mock
    private MovieRepo movieRepo;

    @InjectMocks
    private MovieServices movieServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateMovie() {
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        movie.setDescription("Test Description");
        movie.setRating("90");
        movie.setImage("test.jpg");

        when(movieRepo.save(movie)).thenReturn(movie);

        movieServices.create(movie);

        verify(movieRepo).save(movie);
    }
}
