package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Movie;
import com.example.SaveMySpot.service.Implement.MovieServiceImpl;
import com.example.SaveMySpot.service.Interface.MovieService;
import com.example.SaveMySpot.view.Admin.MovieView;

import java.util.List;

public class MovieController {

    private final MovieView movieView;
    private final MovieService movieService;

    public MovieController() {
        movieView = new MovieView();
        movieService = new MovieServiceImpl();
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    public Movie getMovieDetails(int movieId) {
        return movieService.getMovieDetails(movieId);
    }
}