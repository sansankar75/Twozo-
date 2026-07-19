package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository {

    void save(Show show);
    List<Show> findByMovie(int movieId);

    Iterable<Object> findByScreen(int screenId);

    Show findById(int showId);

    List<Show> getShowsByMovie(int movieId);

    List<Show> getShowsByMovieAndDate(int movieId, LocalDate showDate);

    List<Show> getShowsByScreenAndDate(int screenId, LocalDate showDate);

    List<Show> getShowsByTheaterAndMovie(int theaterId, int movieId, LocalDate showDate);

    void update(Show show);

    void delete(int showId);
}
