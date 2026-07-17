package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Show;

import java.util.List;

public interface ShowRepository {

    void save(Show show);
    List<Show> findByMovie(int movieId);

    Iterable<Object> findByScreen(int screenId);
}
