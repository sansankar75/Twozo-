package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Genre;

import java.util.List;

public interface GenreRepository {

    void save(Genre genre);
    List<Genre> findAll();

}