package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.enums.SeatStatus;
import com.example.SaveMySpot.model.ShowSeat;

import java.util.List;

public interface ShowSeatRepository {

    void save(ShowSeat showSeat);
    List<ShowSeat> findByShow(int showId);
    void updateStatus(int showSeatId, SeatStatus status);

}
