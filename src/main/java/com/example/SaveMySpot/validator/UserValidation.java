package com.example.SaveMySpot.validator;

import com.example.SaveMySpot.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$"
    );
    private static final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[a-zA-Z\\s]{3,30}$"
    );
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-zA-Z])(?=.*[\\d@$!%*?&])[a-zA-Z\\d@$!%*?&]{5,}$"
    );

    public UserValidation() {
    }

    public boolean emailValid(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return false;
        }
        String email = user.getEmail().trim();
        Matcher matcher = EMAIL_PATTERN.matcher(email);

        return matcher.matches();
    }

    public boolean isUserNameValid(User user) {
        if (user == null || user.getName() == null || user.getName().trim().isEmpty()) {
            return false;
        }
        String name = user.getName().trim();
        Matcher matcher = USERNAME_PATTERN.matcher(name);

        return matcher.matches();
    }
    public boolean isPasswordValid(User user) {
        if (user == null || user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }
        String password = user.getPassword();
        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        return matcher.matches();
    }
    public boolean isUserInfoValid(User user) {
        if (user == null) {
            return false;
        }
        return emailValid(user) && isUserNameValid(user) && isPasswordValid(user);
    }
}