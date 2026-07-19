package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.repo.ActorRepository;
import com.example.SaveMySpot.repo.GenreRepository;
import com.example.SaveMySpot.repo.ShowRepository;
import com.example.SaveMySpot.service.MovieService;
import com.example.SaveMySpot.view.MovieView;
import com.example.SaveMySpot.entity.Movie;

import java.util.List;

public class MovieController {
    private final MovieView movieView;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;
    private final ShowRepository showRepository;
    private final MovieService movieService;

    public MovieController(MovieView movieView,
                           MovieService movieService,
                           ActorRepository actorRepository,
                           GenreRepository genreRepository,
                           ShowRepository showRepository
    ) {
        this.movieView = movieView;
        this.movieService = movieService;
        this.actorRepository = actorRepository;
        this.genreRepository = genreRepository;
        this.showRepository = showRepository;
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    public Movie getMovieDetails(int movieId) {
        return movieService.getMovieDetails(movieId);
    }
    public List<Actor> getActorByMovie(int movieId) {
        return movieService.getActorByMovie(movieId);
    }

}