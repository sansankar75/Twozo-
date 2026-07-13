package com.example.SaveMySpot.show;

import java.util.List;

public interface ShowSeatRepository {

    void save(ShowSeat showSeat);
    List<ShowSeat> findByShow(int showId);
    void updateStatus(int showSeatId, ShowRepositoryImpl.SeatStatus status);

}
