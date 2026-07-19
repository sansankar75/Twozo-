package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Screen;

import java.util.List;

public interface ScreenRepository {

    void save(Screen screen);
    List<Screen> findByTheater(int theaterId);

    Screen findById(int screenId);

    List<Screen> getAllScreen();

    List<Screen> getScreensByTheater(int theaterId);

    void update(Screen screen);

    void delete(int screenId);
}
