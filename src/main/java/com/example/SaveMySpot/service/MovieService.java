package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieDetails(int movieId);

    List<Actor> getActorByMovie(int movieId);

}
