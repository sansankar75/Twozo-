package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.User;

public interface UserService {

    void updateProfile(User user);
    User getProfile(int userId);

}
