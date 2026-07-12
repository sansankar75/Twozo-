package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Seat;

import java.util.List;

public interface SeatRepository {

    void save(Seat seat);
    List<Seat> findByScreen(int screenId);

}
