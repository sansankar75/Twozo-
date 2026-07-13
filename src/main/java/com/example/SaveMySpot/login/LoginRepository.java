package com.example.SaveMySpot.login;

import com.example.SaveMySpot.user.User;

public interface LoginRepository {

    User findByEmail(String email);

}
