package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.Movie;
import com.example.SaveMySpot.repository.Implement.MovieRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.MovieRepository;
import com.example.SaveMySpot.service.Interface.MovieService;

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