package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Genre;
import com.example.SaveMySpot.entity.Movie;

import java.util.List;

public interface GenreRepository {

    void save(Genre genre);
    List<Genre> findAll();
    Genre findById(int genreId);
    List<Genre> getAllGenre();
    List<Genre> getGenresByMovie(int movieId);
    List<Movie> getMoviesByGenreName(String genreName);
    void delete(int genreId);
}