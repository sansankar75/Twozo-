package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.User;

public interface LoginRepository {

    User findByEmail(String email);

}
