package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.exception.LoginException;
import com.example.SaveMySpot.repo.LoginRepository;
import com.example.SaveMySpot.repo.UserRepository;
import com.example.SaveMySpot.view.LoginView;

public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    private final LoginView loginView;
    private final UserRepository userRepository;

    private static final String LOGOUT_SUCCESS_MESSAGE =
            "Logged out successfully \uD83D\uDE04.";
    private static final String FRIENDLY_SUGGESTION_TO_CREATE_ACCOUNT =
            "I Think \uD83E\uDD14 You are New User , Can Help you to Create a New Account ?.";
    private static final String LOGIN_INPUT_NULL_MESSAGE =
            "User cannot be null.";

    public LoginServiceImpl(
            LoginRepository loginRepository,
            LoginView loginView,
            UserRepository userRepository
    ) {
        this.loginRepository = loginRepository;
        this.loginView = loginView;
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        if (user == null) {
            throw new LoginException(LOGIN_INPUT_NULL_MESSAGE);
        }

        User existingUser = loginRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            loginView.showMessage(FRIENDLY_SUGGESTION_TO_CREATE_ACCOUNT);
            return null;
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return null;
        }

        return existingUser;
    }

    @Override
    public void addNewUser(User user) {
        if (user == null) {
            throw new LoginException(LOGIN_INPUT_NULL_MESSAGE);
        }

        userRepository.addUser(user);
    }

    @Override
    public String logout() {
        return LOGOUT_SUCCESS_MESSAGE;
    }
}