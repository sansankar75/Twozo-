package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Seat;
import com.example.SaveMySpot.entity.Show;
import com.example.SaveMySpot.entity.ShowSeat;

import java.util.List;

public interface ShowService {

    void createShow(Show show);
    List<Show> getShowsByMovie(int movieId);
    void generateShowSeats(int showId);

    void updateShow(Show show);

    void deleteShow(int showId);
}
