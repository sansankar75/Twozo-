package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.User;

public interface LoginRepository {

    User findByEmail(String email);

}
