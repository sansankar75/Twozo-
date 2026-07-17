package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.entity.*;
import com.example.SaveMySpot.service.*;
import com.example.SaveMySpot.view.AdminView;

import java.util.List;

public class AdminController {
    private final AdminView adminView;
    private final AdminService adminService;
    private final TheaterService theaterService;
    private final ShowService showService;

    public AdminController(AdminView adminView,
                           AdminService adminService,
                           TheaterService theaterService,
                           ShowService showService) {

        this.adminView = adminView;
        this.adminService = adminService;
        this.theaterService = theaterService;
        this.showService = showService;
    }

    public void showAdminMenu(){
        adminView.showMessage("===========Welcome Admin========");
        adminView.showMenu();
    }
    public void addMovie(Movie movie) {
        adminService.addMovie(movie);
        adminView.showMessage("Movie added successfully.");
    }
    public void updateMovie(Movie movie) {
        adminService.updateMovie(movie);
        adminView.showMessage("Movie updated successfully.");
    }
    public void deleteMovie(int movieId) {
        adminService.deleteMovie(movieId);
        adminView.showMessage("Movie deleted successfully.");
    }
    public void addTheater(Theater theater) {
        theaterService.addTheater(theater);
        adminView.showMessage("Theater added successfully.");
    }
    public void addScreen(Screen screen) {
        theaterService.addScreen(screen);
        adminView.showMessage("Screen added successfully.");
    }

    public void addSeat(ShowSeat.Seat seat) {
        theaterService.addSeat(seat);
        adminView.showMessage("Seat added successfully.");
    }
    public void createShow(Show show) {
        showService.createShow(show);
        adminView.showMessage("Show created successfully.");
    }
    public List<Show> getShowsByMovie(int movieId) {
        return showService.getShowsByMovie(movieId);
    }
    public void generateShowSeats(int showId) {
        showService.generateShowSeats(showId);
    }
}