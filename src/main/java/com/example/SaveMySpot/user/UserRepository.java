package com.example.SaveMySpot.user;

public interface UserRepository {

    void save(User user);
    User findById(int userId);
    void update(User user);

}