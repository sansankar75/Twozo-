package com.example.SaveMySpot.user;

public interface UserService {

    void updateProfile(User user);
    User getProfile(int userId);

}
