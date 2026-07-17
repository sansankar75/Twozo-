package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.User;

public interface UserRepository {

    void save(User user);
    User findById(int userId);
    void  update(User user);

}