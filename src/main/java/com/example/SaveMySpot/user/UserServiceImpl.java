package com.example.SaveMySpot.user;

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