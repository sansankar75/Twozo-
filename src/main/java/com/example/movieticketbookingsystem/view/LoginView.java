package com.example.movieticketbookingsystem.view;

import com.example.movieticketbookingsystem.model.User;
import com.example.movieticketbookingsystem.LoggerSystem.UserLogger;

import java.util.Scanner;

public class LoginView {
    UserLogger logger = UserLogger.getInstance();

    public User show() {

        String userName = "";
        String password = "";

        try (Scanner scan = new Scanner(System.in)) {

            // User login page
            System.out.println("========================================");
            System.out.println(" MOVIE TICKET BOOKING SYSTEM LOGIN PAGE");
            System.out.println("========================================");
            System.out.println();
            System.out.println("Enter Username:");
            userName = scan.nextLine();
            System.out.println("=========================");
            System.out.println("Enter password:");
            password = scan.nextLine();

            // logger
            logger.logit("User data entry completed ",
                    "Completed",
                    "Operation from LoginView file in view folder");

            // user model
            return User.builder()
                    .userName(userName)
                    .password(password)
                    .build();

        }
    }
}
