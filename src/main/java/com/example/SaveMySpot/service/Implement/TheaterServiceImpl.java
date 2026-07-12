package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.Screen;
import com.example.SaveMySpot.model.Seat;
import com.example.SaveMySpot.model.Theater;
import com.example.SaveMySpot.repository.Implement.ScreenRepositoryImpl;
import com.example.SaveMySpot.repository.Implement.SeatRepositoryImpl;
import com.example.SaveMySpot.repository.Implement.TheaterRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.ScreenRepository;
import com.example.SaveMySpot.repository.Interface.SeatRepository;
import com.example.SaveMySpot.repository.Interface.TheaterRepository;
import com.example.SaveMySpot.service.Interface.TheaterService;

public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository = new TheaterRepositoryImpl();
    private final ScreenRepository screenRepository = new ScreenRepositoryImpl();
    private final SeatRepository seatRepository = new SeatRepositoryImpl();

    @Override
    public void addTheater(Theater theater) {

        if (theater == null) {
            throw new IllegalArgumentException("Theater cannot be null.");
        }

        theaterRepository.save(theater);
    }

    @Override
    public void addScreen(Screen screen) {

        if (screen == null) {
            throw new IllegalArgumentException("Screen cannot be null.");
        }

        screenRepository.save(screen);
    }

    @Override
    public void addSeat(Seat seat) {

        if (seat == null) {
            throw new IllegalArgumentException("Seat cannot be null.");
        }

        seatRepository.save(seat);
    }
}