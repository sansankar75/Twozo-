package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.User;

public interface UserService {

    void updateProfile(User user);
    User getProfile(int userId);

}
