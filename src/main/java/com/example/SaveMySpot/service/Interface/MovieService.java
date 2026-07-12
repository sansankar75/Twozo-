package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieDetails(int movieId);

}
