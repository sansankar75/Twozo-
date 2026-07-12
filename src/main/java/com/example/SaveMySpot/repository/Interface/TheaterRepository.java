package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Theater;

public interface TheaterRepository {

    void save(Theater theater);
    Theater findById(int theaterId);

}
