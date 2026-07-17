package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Movie;

public interface AdminService {

    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);


}
