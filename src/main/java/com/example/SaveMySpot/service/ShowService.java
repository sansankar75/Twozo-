package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Show;
import com.example.SaveMySpot.entity.ShowSeat;

import java.util.List;

public interface ShowService {

    void createShow(Show show);
    List<Show> getShowsByMovie(int movieId);
    void generateShowSeats(int showId);

    interface SeatRepository {

        void save(ShowSeat.Seat seat);
        List<ShowSeat.Seat> findByScreen(int screenId);

    }
}
