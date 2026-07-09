package com.example.SaveMySpot.view;

import com.example.SaveMySpot.loggersystem.UserLogger;

import java.util.Scanner;

public class LoginView {
    private static final UserLogger logger = UserLogger.getInstance();

    public void show() {

        String userName = "";
        String password = "";

        try (Scanner scan = new Scanner(System.in)) {

            // User login page
            System.out.println("========================================");
            System.out.println(" MOVIE TICKET BOOKING SYSTEM LOGIN PAGE ");
            System.out.println("========================================");
            System.out.println();
            System.out.print("Enter Username:");
            userName = scan.nextLine();

            if(userName.isEmpty()){
                throw new IllegalArgumentException("Username cant not be empty");
            }

            System.out.println("=========================");
            System.out.print("Enter password:");
            password = scan.nextLine();

            if(password.isEmpty()){
                throw new IllegalArgumentException("password cant be empty");
            }

            // logger
            logger.logit("User login attempt for user :"+userName,
                    "Completed",
                    "Operation from LoginView file in view folder");
            //User user = new User(userName, password);


        }
    }
}
