package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Seat;
import com.example.SaveMySpot.entity.ShowSeat;

import java.util.List;

public interface SeatRepository {

    void save(Seat seat);

    Seat findById(int seatId);

    List<Seat> getSeatsByScreen(int screenId);

    List<Seat> getSeatsByType(int screenId, String seatType);

    void delete(int seatId);


}