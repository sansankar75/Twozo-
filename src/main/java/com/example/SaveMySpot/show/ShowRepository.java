package com.example.SaveMySpot.show;

import java.util.List;

public interface ShowRepository {

    void save(Show show);
    List<Show> findByMovie(int movieId);

    Iterable<Object> findByScreen(int screenId);
}
