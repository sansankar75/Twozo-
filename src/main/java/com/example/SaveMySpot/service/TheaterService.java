package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Movie;
import com.example.SaveMySpot.entity.Screen;
import com.example.SaveMySpot.entity.ShowSeat;
import com.example.SaveMySpot.entity.Theater;

import java.util.List;

public interface TheaterService {

    void addTheater(Theater theater);
    void addScreen(Screen screen);
    void addSeat(ShowSeat.Seat seat);
    Theater getTheater(int theaterId);
    List<Theater> getAllTheaters();
    List<Screen> getScreensByTheater(int theaterId);
    List<ShowSeat.Seat> getSeatsByScreen(int screenId);
    List<Movie> getMoviesByTheater(int theaterId);
}
