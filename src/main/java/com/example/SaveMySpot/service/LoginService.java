package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.User;

public interface LoginService {

    User login(User user);
    String logout();

}
