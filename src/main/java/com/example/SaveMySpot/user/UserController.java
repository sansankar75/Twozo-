package com.example.SaveMySpot.user;

import com.example.SaveMySpot.movie.MovieController;
import com.example.SaveMySpot.movie.MovieView;
import com.example.SaveMySpot.booking.BookingView;

public class UserController {
    private final UserInterfaceView userView;
    private final UserService userService;
    private final MovieController movieController;
    private final MovieView movieView;
    private final BookingView bookingView;

    public UserController() {
        userView = new UserInterfaceView();
        userService = new UserServiceImpl();
        movieController = new MovieController();
        movieView = new MovieView();
        bookingView = new BookingView();
    }
    public void showUserMenu(){
        userView.showMessage("========Welcome User========");
        userChoice(userView.show());
    }
    public void updateProfile(User user) {
        userService.updateProfile(user);
        userView.showMessage("Profile updated successfully.");
    }
    public User getProfile(int userId) {
        return userService.getProfile(userId);
    }

    public void userChoice(int choice){
        switch (choice){
            case 1:
                movieView.displayMovies(movieController.getAllMovies());
                movieView.displayMovie(movieController.getMovieDetails(bookingView.selectMovie()));
        }
    }
}