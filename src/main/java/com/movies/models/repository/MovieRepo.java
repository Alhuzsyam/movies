package com.movies.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.movies.models.entity.Movie;

public interface MovieRepo extends CrudRepository <Movie, Long> {
    
}
