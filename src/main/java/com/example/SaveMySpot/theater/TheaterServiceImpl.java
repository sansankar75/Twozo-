package com.example.SaveMySpot.theater;

import com.example.SaveMySpot.movie.Movie;
import com.example.SaveMySpot.show.*;
import com.example.SaveMySpot.movie.MovieRepositoryImpl;
import com.example.SaveMySpot.movie.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository = new TheaterRepositoryImpl();
    private final ScreenRepository screenRepository = new ScreenRepositoryImpl();
    private final ShowService.SeatRepository seatRepository = new ShowStatus.SeatRepositoryImpl();
    private final MovieRepository movieRepository = new MovieRepositoryImpl();
    private final ShowRepository showRepository = new ShowRepositoryImpl();

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
    public void addSeat(ShowSeat.Seat seat) {
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
    public List<ShowSeat.Seat> getSeatsByScreen(int screenId) {

        return seatRepository.findByScreen(screenId);
    }

//    @Override
//    public List<Theater> getAllTheaters() {
//
//        // Add findAll() in TheaterRepository if not already present.
//        return theaterRepository();
//    }

    @Override
    public List<Movie> getMoviesByTheater(int theaterId) {

        List<Movie> movies = new ArrayList<>();

        List<Screen> screens = screenRepository.findByTheater(theaterId);

//        for (Screen screen : screens) {
//            showRepository.findByScreen(screen.getScreenId())
//                    .forEach(show -> {
//                        Movie movie = movieRepository.findById();
//                        if (movie != null && !movies.contains(movie)) {
//                            movies.add(movie);
//                        }
//                    });
//        }

        return movies;
    }
}