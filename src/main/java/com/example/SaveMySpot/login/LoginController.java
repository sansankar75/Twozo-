package com.example.SaveMySpot.login;

import com.example.SaveMySpot.admin.AdminController;
import com.example.SaveMySpot.user.UserController;
import com.example.SaveMySpot.user.UserRole;
import com.example.SaveMySpot.user.User;

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
            adminController.showAdminMenu();
        } else if (loggedUser.getRole() == UserRole.CUSTOMER) {
            UserController userController = new UserController();
            userController.showUserMenu();
        } else {
            loginView.showError("Unknown user role.");
        }
    }
    public void logout() {
        loginService.logout();
        loginView.showMessage("Logout successful.");
    }
}