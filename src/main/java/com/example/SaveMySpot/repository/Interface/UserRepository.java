package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.User;

public interface UserRepository {

    void save(User user);
    User findById(int userId);
    void update(User user);

}