package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.exception.LoginException;
import com.example.SaveMySpot.repo.LoginRepository;

public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    private static final String LOGOUT_SUCCESS_MESSAGE = "Logged out successfully.";

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public User login(User user) {
        if (user == null) {
            throw new LoginException("User cannot be null.");
        }

        User existingUser = loginRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return null;
        }
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return null;
        }

        return existingUser;
    }

    @Override
    public String logout() {
        return LOGOUT_SUCCESS_MESSAGE;
    }
}