package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.view.UserInterfaceView;
import com.example.SaveMySpot.service.UserService;
import com.example.SaveMySpot.service.UserServiceImpl;
import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.view.BookingView;
import com.example.SaveMySpot.view.MovieView;

public class UserController {
    private final UserInterfaceView userView;
    private final UserService userService;
    private final MovieController movieController;
    private final MovieView movieView;
    private final BookingView bookingView;

    private static final String WELCOME_MESSAGE = "WELCOME , READY TO SAVE YOUR SPOT !";
    private static final String PROFILE_UPDATE_MESSAGE = " PROFILE UPDATED SUCCESSFULLY !";

    public UserController(UserInterfaceView userView,
                          UserService userService,
                          MovieController movieController,
                          MovieView movieView,
                          BookingView bookingView) {

        this.userView = userView;
        this.userService = userService;
        this.movieController = movieController;
        this.movieView = movieView;
        this.bookingView = bookingView;
    }
    public void showUserMenu(){
        userView.showMessage(WELCOME_MESSAGE);
        userChoice(userView.show());
    }
    public void updateProfile(User user) {
        userService.updateProfile(user);
        userView.showMessage(PROFILE_UPDATE_MESSAGE);
    }
    public User getProfile(int userId) {
        return userService.getProfile(userId);
    }

    public void userChoice(int choice){
        switch (choice){
            case 1:
                movieView.displayMovies(movieController.getAllMovies());
                movieView.displayMovie(movieController.getMovieDetails(bookingView.selectMovie()));
                break;
        }
    }
}