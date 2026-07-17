package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.repo.ActorRepository;
import com.example.SaveMySpot.repo.GenreRepository;
import com.example.SaveMySpot.repo.ShowRepository;
import com.example.SaveMySpot.service.MovieService;
import com.example.SaveMySpot.view.MovieView;
import com.example.SaveMySpot.entity.Movie;

import java.util.List;

public class MovieController {
    private final MovieView movieView;
    private final MovieService movieService;

    public MovieController(MovieView movieView,
                           MovieService movieService,
                           ActorRepository actorRepository,
                           GenreRepository genreRepository,
                           ShowRepository showRepository
    ) {
        this.movieView = movieView;
        this.movieService = movieService;
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    public Movie getMovieDetails(int movieId) {
        return movieService.getMovieDetails(movieId);
    }

}