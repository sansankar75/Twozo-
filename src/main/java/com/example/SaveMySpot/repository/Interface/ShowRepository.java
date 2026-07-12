package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Show;

import java.util.List;

public interface ShowRepository {

    void save(Show show);
    List<Show> findByMovie(int movieId);

}
