package com.example.SaveMySpot.movie;

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