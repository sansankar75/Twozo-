package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.Enum.UserRole;
import com.example.SaveMySpot.repo.LoginRepository;
import com.example.SaveMySpot.service.LoginService;
import com.example.SaveMySpot.validator.UserValidation;
import com.example.SaveMySpot.view.AdminView;
import com.example.SaveMySpot.view.LoginView;
import com.example.SaveMySpot.view.UserInterfaceView;

public class LoginController {

    private final UserInterfaceView userInterfaceView;
    private final LoginRepository loginRepository;
    private final LoginService loginService;
    private final UserValidation userValidation;
    private final AdminView adminView;
    private final LoginView loginView;

    private String loggedInUser = null;

    public LoginController(UserInterfaceView userInterfaceView,
                           LoginRepository loginRepositoryImpl,
                           LoginService loginServiceImpl,
                           UserValidation userValidation,
                           AdminView adminView,
                           LoginView loginView) {
        this.userInterfaceView = userInterfaceView;
        this.loginRepository = loginRepositoryImpl;
        this.loginService = loginServiceImpl;
        this.userValidation = userValidation;
        this.adminView = adminView;
        this.loginView = loginView;
    }

    public String login() {
        User loginUser = loginView.show();

        // Validate input BEFORE attempting login, and stop on failure.
        if (!userValidation.isUserInfoValid(loginUser)) {
            loginView.showError("Please enter a valid email and username.");
            return " Invalid input ";
        }

        User loggedUser = loginService.login(loginUser);

        if (loggedUser == null) {
            loginView.showError("Invalid email or password.");
            return " ";
        }

        loginView.showMessage("Login successful.");

        if (loggedUser.getRole() == UserRole.ADMIN) {
            loggedInUser = "Admin";
            return loggedInUser;
        } else if (loggedUser.getRole() == UserRole.CUSTOMER) {
            loggedInUser = "Customer";
            return loggedInUser;
        } else {
            loginView.showError("Unknown user role.");
        }
        return " ";
    }

    public void logout() {
        if (loggedInUser == null) {
            userInterfaceView.showMessage("No user is currently logged in.");
            return;
        }

        if (loggedInUser.equals("Admin")) {
            adminView.showMessage(loginService.logout());
        } else {
            userInterfaceView.showMessage(loginService.logout());
        }

        loggedInUser = null;
    }
}