package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.User;
import com.example.SaveMySpot.service.Implement.UserServiceImpl;
import com.example.SaveMySpot.service.Interface.UserService;
import com.example.SaveMySpot.view.user.UserInterfaceView;

public class UserController {

    private final UserInterfaceView userView;
    private final UserService userService;

    public UserController() {
        userView = new UserInterfaceView();
        userService = new UserServiceImpl();
    }

    public void updateProfile(User user) {
        userService.updateProfile(user);
        userView.showMessage("Profile updated successfully.");
    }

    public User getProfile(int userId) {
        return userService.getProfile(userId);
    }
}