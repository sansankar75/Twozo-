package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.User;
import com.example.SaveMySpot.repository.Implement.UserRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.UserRepository;
import com.example.SaveMySpot.service.Interface.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void updateProfile(User user) {

        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        userRepository.update(user);
    }

    @Override
    public User getProfile(int userId) {

        return userRepository.findById(userId);
    }
}