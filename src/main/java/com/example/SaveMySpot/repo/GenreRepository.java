package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Genre;

import java.util.List;

public interface GenreRepository {

    void save(Genre genre);
    List<Genre> findAll();

}