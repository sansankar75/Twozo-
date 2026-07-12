package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.Show;
import com.example.SaveMySpot.repository.Implement.ShowRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.ShowRepository;
import com.example.SaveMySpot.service.Interface.ShowService;

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

        // Generate ShowSeat records later.
    }
}