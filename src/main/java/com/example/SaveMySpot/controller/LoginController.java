package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.enums.UserRole;
import com.example.SaveMySpot.model.User;
import com.example.SaveMySpot.service.Implement.LoginServiceImpl;
import com.example.SaveMySpot.service.Interface.LoginService;
import com.example.SaveMySpot.view.LoginView;

public class LoginController {

    private final LoginView loginView;
    private final LoginService loginService;

    public LoginController() {
        loginView = new LoginView();
        loginService = new LoginServiceImpl();
    }

    public void login() {

        User loginUser = loginView.show();

        User loggedUser = loginService.login(loginUser);

        if (loggedUser == null) {
            loginView.showError("Invalid email or password.");
            return;
        }

        loginView.showMessage("Login successful.");

        if (loggedUser.getRole() == UserRole.ADMIN) {

            AdminController adminController = new AdminController();

            // adminController.start();

        } else if (loggedUser.getRole() == UserRole.CUSTOMER) {

            UserController userController = new UserController();

            // userController.start();

        } else {

            loginView.showError("Unknown user role.");

        }
    }

    public void logout() {
        loginService.logout();
        loginView.showMessage("Logout successful.");
    }
}