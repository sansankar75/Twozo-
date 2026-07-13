package com.example.SaveMySpot.theater;

import com.example.SaveMySpot.movie.Movie;
import com.example.SaveMySpot.show.ShowSeat;

import java.util.List;

public class TheaterController {

    private final TheaterView theaterView;
    private final TheaterService theaterService;

    public TheaterController() {
        theaterView = new TheaterView();
        theaterService = new TheaterServiceImpl();
    }

    public void addTheater(Theater theater) {
        theaterService.addTheater(theater);
        theaterView.showMessage("Theater added successfully.");
    }

    public void addScreen(Screen screen) {
        theaterService.addScreen(screen);
        theaterView.showMessage("Screen added successfully.");
    }

    public void addSeat(ShowSeat.Seat seat) {
        theaterService.addSeat(seat);
        theaterView.showMessage("Seat added successfully.");
    }

    public Theater getTheater(int theaterId) {
        return theaterService.getTheater(theaterId);
    }

    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    public List<Screen> getScreensByTheater(int theaterId) {
        return theaterService.getScreensByTheater(theaterId);
    }

    public List<ShowSeat.Seat> getSeatsByScreen(int screenId) {
        return theaterService.getSeatsByScreen(screenId);
    }

    public List<Movie> getMoviesByTheater(int theaterId) {
        return theaterService.getMoviesByTheater(theaterId);
    }
}