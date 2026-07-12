package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Show;
import com.example.SaveMySpot.service.Implement.ShowServiceImpl;
import com.example.SaveMySpot.service.Interface.ShowService;
import com.example.SaveMySpot.view.Admin.ShowView;

import java.util.List;

public class ShowController {

    private final ShowView showView;
    private final ShowService showService;

    public ShowController() {
        showView = new ShowView();
        showService = new ShowServiceImpl();
    }

    public void createShow(Show show) {
        showService.createShow(show);
        showView.showMessage("Show created successfully.");
    }

    public List<Show> getShowsByMovie(int movieId) {
        return showService.getShowsByMovie(movieId);
    }

    public void generateShowSeats(int showId) {
        showService.generateShowSeats(showId);
    }
}