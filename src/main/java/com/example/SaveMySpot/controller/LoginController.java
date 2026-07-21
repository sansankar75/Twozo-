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
    private final AdminController adminController;
    private final UserValidation userValidation;
    private final UserController userController;
    private final LoginService loginService;
    private final AdminView adminView;
    private final LoginView loginView;

    private static final String INVALID_CREDENTIALS_MESSAGE = "Please enter a valid Email or Username , Please Try Again.";
    private static final String NO_LOGGED_IN_USER_MESSAGE = "No user is currently logged in.";
    private static final String LOGIN_SUCCESSFUL_MESSAGE = "Login successful \uD83D\uDE04.";
    private static final String ACCOUNT_CREATED_MESSAGE = "Your User Account created successfully \uD83C\uDF89 , You can Login Now";
    private static final String ROLE_NOT_FOUND_MESSAGE = "Unknown user role.\uD83D\uDD75";
    private static final String OUT_OF_CHOICE_MESSAGE = "Please Enter between given choices";

    private String loggedInUser = null;

    public LoginController(
            UserInterfaceView userInterfaceView,
            LoginRepository loginRepositoryImpl,
            LoginService loginServiceImpl,
            UserValidation userValidation,
            AdminView adminView,
            LoginView loginView,
            AdminController adminController,
            UserController userController
    ) {
        this.userInterfaceView = userInterfaceView;
        this.loginRepository = loginRepositoryImpl;
        this.adminController = adminController;
        this.loginService = loginServiceImpl;
        this.userValidation = userValidation;
        this.adminView = adminView;
        this.loginView = loginView;
        this.userController = userController;
    }

    public void login() {
        User loginUser = loginView.show();

        // Validate input BEFORE attempting login, and stop on failure.
        if (!userValidation.isUserInfoValid(loginUser)) {
            loginView.showError(INVALID_CREDENTIALS_MESSAGE);
        }

        User loggedUser = loginService.login(loginUser);

        if (loggedUser == null) {
            loginOptions();
        }else {
            loginView.showMessage(LOGIN_SUCCESSFUL_MESSAGE);

            if (loggedUser.getRole() == UserRole.ADMIN) {
                adminController.showAdminMenu();
            } else if (loggedUser.getRole() == UserRole.CUSTOMER) {
                userController.showUserMenu();
            } else {
                loginView.showError(ROLE_NOT_FOUND_MESSAGE);
            }
        }
    }

    public void logout() {
        if (loggedInUser == null) {
            userInterfaceView.showMessage(NO_LOGGED_IN_USER_MESSAGE);
            return;
        }

        if (loggedInUser.equals("Admin")) {
            adminView.showMessage(loginService.logout());
        } else {
            userInterfaceView.showMessage(loginService.logout());
        }

        loggedInUser = null;
    }

    public void newUser() {
        User loginUser = loginView.newUser();

        // Validate input BEFORE attempting addUser, and stop on InvalidInput.
        if (!userValidation.isUserInfoValid(loginUser)) {
            loginView.showError(INVALID_CREDENTIALS_MESSAGE);
            loginOptions();
        }else{
            loginService.addNewUser(loginUser);
            loginView.showMessage(ACCOUNT_CREATED_MESSAGE);
            loginOptions();
        }
    }

    public void loginOptions(){
        int option = loginView.loginOption();

        switch (option){
            case 1 -> {
                login();
            }
            case 2 -> newUser();
            case 3 -> System.exit(0);
            default -> {
                loginView.showMessage(OUT_OF_CHOICE_MESSAGE);
                loginOptions();
            }
        }
    }
}
