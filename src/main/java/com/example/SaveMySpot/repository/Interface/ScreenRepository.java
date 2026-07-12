package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Screen;

import java.util.List;

public interface ScreenRepository {

    void save(Screen screen);
    List<Screen> findByTheater(int theaterId);

}
