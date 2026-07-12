package com.example.SaveMySpot.view;

import com.example.SaveMySpot.enums.UserRole;
import com.example.SaveMySpot.model.User;
import com.example.SaveMySpot.util.ConsoleReader;

public class LoginView {

    public User show() {
        User user = new User();

        System.out.println("\n==========================================");
        System.out.println("                  LOGIN");
        System.out.println("==========================================");
        System.out.print("Name     : ");
        user.setName(ConsoleReader.SCANNER.nextLine());
        System.out.print("Email    : ");
        user.setEmail(ConsoleReader.SCANNER.nextLine());
        System.out.print("Password : ");
        user.setPassword(ConsoleReader.SCANNER.nextLine());
        System.out.print("Role : ");
        user.setRole(UserRole.valueOf(ConsoleReader.SCANNER.nextLine()));
        System.out.println("==========================================\n");

        return user;
    }

    public void showError(String error){
        System.out.println(error);
    }

    public void showMessage(String message){
        System.out.println(message);
    }

}