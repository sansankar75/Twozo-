package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.entity.*;
import com.example.SaveMySpot.service.TheaterService;
import com.example.SaveMySpot.service.TheaterServiceImpl;
import com.example.SaveMySpot.view.TheaterView;

import java.util.List;

public class TheaterController {

    private final TheaterView theaterView;
    private final TheaterService theaterService;

    public TheaterController(TheaterView theaterView, TheaterService theaterService) {
        this.theaterView = theaterView;
        this.theaterService = theaterService;
    }


    public void addTheater(Theater theater) {
        theaterService.addTheater(theater);
        theaterView.showMessage("Theater added successfully.");
    }

    public void addScreen(Screen screen) {
        theaterService.addScreen(screen);
        theaterView.showMessage("Screen added successfully.");
    }

    public void addSeat(Seat seat) {
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

    public List<Movie> getMoviesByTheater(int theaterId , int movieId) {
        return theaterService.getMoviesByTheater(theaterId, movieId);
    }
}