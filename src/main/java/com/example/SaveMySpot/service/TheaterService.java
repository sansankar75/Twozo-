package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.*;

import java.util.List;

public interface TheaterService {

    void addTheater(Theater theater);
    void addScreen(Screen screen);
    void addSeat(Seat seat);

    Theater getTheater(int theaterId);
    List<Theater> getAllTheaters();
    List<Screen> getScreensByTheater(int theaterId);
    List<Movie> getMoviesByTheater(int theaterId, int movieId);
}
