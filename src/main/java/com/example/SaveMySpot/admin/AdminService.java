package com.example.SaveMySpot.admin;

import com.example.SaveMySpot.movie.Movie;

public interface AdminService {

    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);


}
