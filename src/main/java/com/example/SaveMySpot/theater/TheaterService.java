package com.example.SaveMySpot.theater;

import com.example.SaveMySpot.movie.Movie;
import com.example.SaveMySpot.show.ShowSeat;

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
