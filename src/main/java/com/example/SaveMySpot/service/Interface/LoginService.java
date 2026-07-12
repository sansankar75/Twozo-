package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.User;

public interface LoginService {

    User login(User user);
    void logout();

}
