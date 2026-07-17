package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.ShowSeat;

import java.util.List;

public interface ShowSeatRepository {

    void save(ShowSeat showSeat);
    List<ShowSeat> findByShow(int showId);
    void updateStatus(int showSeatId, ShowRepositoryImpl.SeatStatus status);

}
