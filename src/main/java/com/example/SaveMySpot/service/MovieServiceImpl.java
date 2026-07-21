package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.entity.Movie;
import com.example.SaveMySpot.repo.MovieRepository;
import com.example.SaveMySpot.repo.ActorRepository;
import com.example.SaveMySpot.repo.GenreRepository;
import com.example.SaveMySpot.repo.ShowRepository;
import com.example.SaveMySpot.repo.MovieRepositoryImpl;
import com.example.SaveMySpot.exception.MovieNotFoundException;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private static final String INVALID_MOVIE_ID_MESSAGE = "Please Enter Invalid Movie ID";

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovie();

    }

    @Override
    public Movie getMovieDetails(int movieId) {
        if (movieId <= 0) {
            throw new MovieNotFoundException(INVALID_MOVIE_ID_MESSAGE);
        }

        return movieRepository.findById(movieId);

    }

    @Override
    public List<Actor> getActorByMovie(int movieId) {
        if (movieId <= 0){
            throw new MovieNotFoundException(INVALID_MOVIE_ID_MESSAGE);
        }

        return movieRepository.getMovieActors(movieId);
    }
}