package com.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.dto.Response;
import com.movies.models.entity.Movie;
import com.movies.services.MovieServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class movieController {

    @Autowired
    MovieServices mServices;

    Response<Object> res = new Response<>();

    
    @GetMapping("/welcome/{name}")
    public String Welcome(@PathVariable String name){
        return "Selmat datang " + name;
    }

    @PostMapping("/movie")
    public Movie create(@Valid @RequestBody Movie movie){
        return mServices.create(movie);
    }

    @GetMapping("/movie")
    public Iterable<Movie> findall(){
        return mServices.getall();
    }

    @GetMapping("/movie/{id}")
    public Response<Object> findone(@PathVariable("id") Long id){
        try{
            // mServices.findOne(id);
           if(mServices.findOne(id) != null){
            res.setMessage("Data is not exist");
            res.setStatus("200 OK");
            res.setPayload(mServices.findOne(id));
           }else{
            res.setMessage("error");
            res.setStatus("400 BAD_REQUEST");
            // res.setPayload(mServices.findOne(id));
           }
        }catch(Exception e){
            e.getCause();
        }
        return res;
    }

     @DeleteMapping("/movie/{id}")
    public void remove(@PathVariable("id") Long id){
         mServices.RemoveOne(id);
    }

    @PutMapping("/movie/{id}")
public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
    Movie existingMovie = mServices.findOne(id);
    
    if (existingMovie == null) {
        return ResponseEntity.notFound().build();
    }
    
    // Update movie details
    existingMovie.setTitle(updatedMovie.getTitle());
    existingMovie.setDescription(updatedMovie.getDescription());
    existingMovie.setRating(updatedMovie.getRating());
    existingMovie.setImage(updatedMovie.getImage());
    
    // Save the updated movie
    Movie savedMovie = mServices.create(existingMovie);
    
    return ResponseEntity.ok(savedMovie);
}


}
