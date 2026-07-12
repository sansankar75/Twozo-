package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Movie;

public interface AdminService {

    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);


}
