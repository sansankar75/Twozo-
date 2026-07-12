package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.Movie;
import com.example.SaveMySpot.repository.Implement.MovieRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.MovieRepository;
import com.example.SaveMySpot.service.Interface.AdminService;

public class AdminServiceImpl implements AdminService {

    private final MovieRepository movieRepository = new MovieRepositoryImpl();

    @Override
    public void addMovie(Movie movie) {

        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title is required.");
        }

        if (movie.getDuration() <= 0) {
            throw new IllegalArgumentException("Invalid movie duration.");
        }

        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {

        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        Movie existingMovie = movieRepository.findById(movie.getMovieId());

        if (existingMovie == null) {
            throw new RuntimeException("Movie not found.");
        }

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setPosterUrl(movie.getPosterUrl());

        movieRepository.update(existingMovie);
    }

    @Override
    public void deleteMovie(int movieId) {

        Movie movie = movieRepository.findById(movieId);

        if (movie == null) {
            throw new RuntimeException("Movie not found.");
        }

        movieRepository.delete(movieId);
    }
}