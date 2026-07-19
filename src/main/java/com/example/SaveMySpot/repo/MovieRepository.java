package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.entity.Movie;

import java.util.List;

public interface MovieRepository {

    void save(Movie movie);
    Movie findById(int movieId);
    List<Movie> findAllMovie();
    void update(Movie movie);
    void delete(int movieId);
    List<Actor> getMovieActors(int movieId);
    List<Movie> searchMovieByTitle(String title);
    List<Movie> getMoviesByLanguage(String language);
    List<Movie> getUpcomingMovies();
    List<Movie> getNowShowingMovies();
    List<Movie> getMoviesByGenre(int genreId);
    long countMovies();
}
