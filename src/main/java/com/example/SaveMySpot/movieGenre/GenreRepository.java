package com.example.SaveMySpot.movieGenre;

import java.util.List;

public interface GenreRepository {

    void save(Genre genre);
    List<Genre> findAll();

}