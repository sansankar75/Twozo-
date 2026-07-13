package com.example.SaveMySpot.admin;

import com.example.SaveMySpot.movie.Movie;
import com.example.SaveMySpot.show.ShowSeat;
import com.example.SaveMySpot.theater.Screen;
import com.example.SaveMySpot.show.Show;
import com.example.SaveMySpot.theater.Theater;
import com.example.SaveMySpot.show.ShowServiceImpl;
import com.example.SaveMySpot.theater.TheaterServiceImpl;
import com.example.SaveMySpot.show.ShowService;
import com.example.SaveMySpot.theater.TheaterService;

import java.util.List;

public class AdminController {
    private final AdminView adminView;
    private final AdminService adminService;
    private final TheaterService theaterService;
    private final ShowService showService;

    public AdminController() {
        adminView = new AdminView();
        adminService = new AdminServiceImpl();
        theaterService = new TheaterServiceImpl();
        showService = new ShowServiceImpl();
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