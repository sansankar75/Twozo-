package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Movie;
import com.example.SaveMySpot.service.Implement.AdminServiceImpl;
import com.example.SaveMySpot.service.Interface.AdminService;
import com.example.SaveMySpot.view.Admin.AdminView;

public class AdminController {

    private final AdminView adminView;
    private final AdminService adminService;

    public AdminController() {
        adminView = new AdminView();
        adminService = new AdminServiceImpl();
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
        if (adminView.confirmAction()) {
            adminService.deleteMovie(movieId);
            adminView.showMessage("Movie deleted successfully.");
        }
    }
}