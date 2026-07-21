package com.example.SaveMySpot;

import com.example.SaveMySpot.controller.*;
import com.example.SaveMySpot.repo.*;
import com.example.SaveMySpot.service.*;
import com.example.SaveMySpot.validator.*;
import com.example.SaveMySpot.view.*;

public class Main {
    public static void main(String[] args) {

        // Build dependencies first, then inject them into the controller.
        // TODO: replace no-arg constructors below with real ones once
        // those classes' constructors are finalized.

        LoginRepository loginRepository = new LoginRepositoryImpl();
        TheaterRepository theaterRepository = new TheaterRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        ScreenRepository screenRepository = new ScreenRepositoryImpl();
        SeatRepository seatRepository = new SeatRepositoryImpl();
        ActorRepository actorRepository = new ActorRepositoryImpl();
        GenreRepository genreRepository = new GenreRepositoryImpl();
        ShowRepository showRepository = new ShowRepositoryImpl();
        MovieRepository movieRepository = new MovieRepositoryImpl();

        AdminService adminService = new AdminServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl(theaterRepository,
                screenRepository,
                seatRepository,
                movieRepository,
                showRepository);


        UserService userService = new UserServiceImpl();
        ShowService showService = new ShowServiceImpl();
        MovieService movieService = new MovieServiceImpl(movieRepository);

        UserValidation userValidation = new UserValidation();

        AdminView adminView = new AdminView();
        LoginView loginView = new LoginView();
        TheaterView theaterView = new TheaterView();
        MovieView movieView = new MovieView();
        BookingView bookingView = new BookingView();
        UserInterfaceView userView = new UserInterfaceView();
        LoginService loginService = new LoginServiceImpl(loginRepository, loginView, userRepository);


        MovieController movieController = new MovieController(movieView,
                movieService,
                actorRepository,
                genreRepository,
                showRepository);

        AdminController adminController = new AdminController(adminView,
                theaterView,
                adminService,
                theaterService,
                showService,
                movieView
        );
        UserController userController = new UserController(userView,
                userService,
                movieController,
                movieView,
                bookingView,
                loginService
        );
        LoginController loginController = new LoginController(
                userView,
                loginRepository,
                loginService,
                userValidation,
                adminView,
                loginView,
                adminController,
                userController
        );


        loginController.loginOptions();

    }
}

// 2    "Ravi Kumar"    "ravi@gmail.com"    "pass123"    "Tamil"    "Tirunelveli"    "CUSTOMER"
// 1    "aswin"    "admin@movieapp.com"    "admin123"    "English"    "Chennai"    "ADMIN"