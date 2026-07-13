package com.example.SaveMySpot.login;

import com.example.SaveMySpot.user.User;

public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository = new LoginRepositoryImpl();

    @Override
    public User login(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
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
    public void logout() {

        System.out.println("Logged out successfully.");

    }
}