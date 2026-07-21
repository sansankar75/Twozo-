package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.*;
import com.example.SaveMySpot.repo.*;

import java.util.ArrayList;
import java.util.List;

public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository ;
    private final SeatRepository seatRepository ;
    private final MovieRepository movieRepository ;
    private final ShowRepository showRepository ;

    public TheaterServiceImpl(TheaterRepository theaterRepository,
                              ScreenRepository screenRepository,
                              SeatRepository seatRepository,
                              MovieRepository movieRepository,
                              ShowRepository showRepository) {
        this.theaterRepository = theaterRepository;
        this.screenRepository = screenRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
    }

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

    @Override
    public Theater getTheater(int theaterId) {

        return theaterRepository.findById(theaterId);
    }

    @Override
    public List<Theater> getAllTheaters() {
        return List.of();
    }

    @Override
    public List<Screen> getScreensByTheater(int theaterId) {

        return screenRepository.findByTheater(theaterId);
    }

    @Override
    public List<Movie> getMoviesByTheater(int theaterId, int movieId) {

        List<Movie> movies = new ArrayList<>();

        List<Screen> screens = screenRepository.findByTheater(theaterId);

        for (Screen screen : screens) {
            showRepository.findByScreen(screen.getScreenId())
                    .forEach(show -> {
                        Movie movie = movieRepository.findById(movieId);
                        if (movie != null && !movies.contains(movie)) {
                            movies.add(movie);
                        }
                    });
        }

        return movies;
    }
}