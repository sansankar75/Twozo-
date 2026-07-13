package com.example.SaveMySpot.movie;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository = new MovieRepositoryImpl();

    @Override
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();

    }

    @Override
    public Movie getMovieDetails(int movieId) {
        if (movieId <= 0) {
            throw new IllegalArgumentException("Invalid movie id.");
        }

        return movieRepository.findById(movieId);

    }
}