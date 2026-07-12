package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Screen;
import com.example.SaveMySpot.model.Seat;
import com.example.SaveMySpot.model.Theater;

public interface TheaterService {

    void addTheater(Theater theater);
    void addScreen(Screen screen);
    void addSeat(Seat seat);

}
