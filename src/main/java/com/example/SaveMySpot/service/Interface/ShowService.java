package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Show;

import java.util.List;

public interface ShowService {

    void createShow(Show show);
    List<Show> getShowsByMovie(int movieId);
    void generateShowSeats(int showId);

}
