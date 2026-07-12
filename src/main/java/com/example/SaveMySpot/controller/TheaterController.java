package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Screen;
import com.example.SaveMySpot.model.Seat;
import com.example.SaveMySpot.model.Theater;
import com.example.SaveMySpot.service.Implement.TheaterServiceImpl;
import com.example.SaveMySpot.service.Interface.TheaterService;
import com.example.SaveMySpot.view.Admin.TheaterView;

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

    public void addSeat(Seat seat) {
        theaterService.addSeat(seat);
        theaterView.showMessage("Seat added successfully.");
    }
}