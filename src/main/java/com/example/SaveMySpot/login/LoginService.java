package com.example.SaveMySpot.login;

import com.example.SaveMySpot.user.User;

public interface LoginService {

    User login(User user);
    void logout();

}
