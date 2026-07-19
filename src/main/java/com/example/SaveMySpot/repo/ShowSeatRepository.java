package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.ShowSeat;


import java.util.List;

public interface ShowSeatRepository {

    void save(ShowSeat showSeat);
    List<ShowSeat> findByShow(int showId);


    ShowSeat findById(int showSeatId);

    List<ShowSeat> getSeatsByShow(int showId);

    List<ShowSeat> getAvailableSeatsByShow(int showId);

    List<ShowSeat> getExpiredLockedSeats(int showId);

    long countAvailableSeats(int showId);

    void update(ShowSeat showSeat);
}
