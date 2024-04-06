package com.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.models.entity.Movie;
import com.movies.models.repository.MovieRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServices {
    @Autowired
     MovieRepo mRepo;

     public Movie create(Movie movie){
        return mRepo.save(movie);
     }
     public Iterable<Movie> getall(){
        return mRepo.findAll();
     }

     public Movie findOne(Long id){
        Optional<Movie> movie = mRepo.findById(id);

        if(!movie.isPresent()){
            return null;
        }
        return movie.get();
    }
    public void RemoveOne(Long id){ 
        mRepo.deleteById(id);
    }
}
