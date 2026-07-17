package com.example.SaveMySpot;

import com.example.SaveMySpot.controller.*;
import com.example.SaveMySpot.repo.*;
import com.example.SaveMySpot.service.*;
import com.example.SaveMySpot.validator.*;
import com.example.SaveMySpot.view.*;
import org.springframework.boot.jdbc.DataSourceUnwrapper;

public class Main {
    public static void main(String[] args) {

        // Build dependencies first, then inject them into the controller.
        // TODO: replace no-arg constructors below with real ones once
        // those classes' constructors are finalized.

        LoginRepository loginRepository = new LoginRepositoryImpl();
        ActorRepository actorRepository = new ActorRepositoryImpl();
        GenreRepository genreRepository = new GenreRepositoryImpl();
        ShowRepository showRepository = new ShowRepositoryImpl();
        MovieRepository movieRepository = new MovieRepositoryImpl();

        AdminService adminService = new AdminServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl(loginRepository);
        UserService userService = new UserServiceImpl();
        ShowService showService = new ShowServiceImpl();
        MovieService movieService = new MovieServiceImpl(movieRepository);

        UserValidation userValidation = new UserValidation();

        AdminView adminView = new AdminView();
        LoginView loginView = new LoginView();
        MovieView movieView = new MovieView();
        BookingView bookingView = new BookingView();
        UserInterfaceView userView = new UserInterfaceView();

        MovieController movieController = new MovieController(movieView,
                movieService,
                actorRepository,
                genreRepository,
                showRepository);
        LoginController loginController = new LoginController(
                userView,
                loginRepository,
                loginService,
                userValidation,
                adminView,
                loginView
        );

        // for testing user Admin is temporarily not accessible
//        // String role = loginController.login();
//
//        if (role.equals("Admin")){
//            AdminController adminController = new AdminController(adminView,
//                    adminService,
//                    theaterService,
//                    showService);
//            adminController.showAdminMenu();
//        }else{
//            UserController userController = new UserController(userView,
//                    userService,
//                    movieController,
//                    movieView,
//                    bookingView);
//            userController.showUserMenu();
//        }

        // for test purpose only
        UserController userController = new UserController(userView,
                userService,
                movieController,
                movieView,
                bookingView);
        userController.showUserMenu();

    }
}

// 2    "Ravi Kumar"    "ravi@gmail.com"    "pass123"    "Tamil"    "Tirunelveli"    "CUSTOMER"
// 1    "aswin"    "admin@movieapp.com"    "admin123"    "English"    "Chennai"    "ADMIN"