package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Show;
import com.example.SaveMySpot.repo.ShowRepository;
import com.example.SaveMySpot.repo.ShowRepositoryImpl;

import java.util.List;

public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository = new ShowRepositoryImpl();

    @Override
    public void createShow(Show show) {
        if (show == null) {
            throw new IllegalArgumentException("Show cannot be null.");
        }
        showRepository.save(show);
    }

    @Override
    public List<Show> getShowsByMovie(int movieId) {
        return showRepository.findByMovie(movieId);
    }

    @Override
    public void generateShowSeats(int showId) {

        // generate ShowSeat record later
    }
}