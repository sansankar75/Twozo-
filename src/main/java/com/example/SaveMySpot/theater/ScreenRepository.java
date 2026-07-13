package com.example.SaveMySpot.theater;

import java.util.List;

public interface ScreenRepository {

    void save(Screen screen);
    List<Screen> findByTheater(int theaterId);

}
