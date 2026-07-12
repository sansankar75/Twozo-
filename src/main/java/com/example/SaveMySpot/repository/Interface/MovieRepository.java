package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Movie;

import java.util.List;

public interface MovieRepository {

    void save(Movie movie);
    Movie findById(int movieId);
    List<Movie> findAll();
    void update(Movie movie);
    void delete(int movieId);

}
