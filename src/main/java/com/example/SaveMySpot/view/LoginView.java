package com.example.SaveMySpot.view;

import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.Enum.UserRole;

public class LoginView {

    public User show() {
        User user = new User();

        ConsoleReader.SCANNER.nextLine();
        System.out.println("\n==========================================");
        System.out.println("              🔑 LOGIN                   ");
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

    public User newUser() {
        User user = new User();

        ConsoleReader.SCANNER.nextLine();
        System.out.println("\n==========================================");
        System.out.println("           ✨ CREATE NEW ACCOUNT");
        System.out.println("==========================================");
        System.out.print("Name     : ");
        user.setName(ConsoleReader.SCANNER.nextLine());
        System.out.print("Email    : ");
        user.setEmail(ConsoleReader.SCANNER.nextLine());
        System.out.println("NOTE : new Password Must have \n Character and Digit with minimum 5 character length");
        System.out.print("Password : ");
        user.setPassword(ConsoleReader.SCANNER.nextLine());
        System.out.print("Language : ");
        user.setLanguage(ConsoleReader.SCANNER.nextLine());
        System.out.print("City     : ");
        user.setLocation(ConsoleReader.SCANNER.nextLine());
        System.out.print("Role     : ");
        user.setRole(UserRole.valueOf(ConsoleReader.SCANNER.nextLine()));
        System.out.println("==========================================\n");

        return user;
    }

    public int loginOption(){
        System.out.println("\n======================================");
        System.out.println("        🎬 WELCOME TO SAVE MY SPOT       ");
        System.out.println("========================================");
        System.out.println("  📌 Are you a new or existing user?");
        System.out.println("========================================");
        System.out.println("  1. 🔑 Sign In     (I have an account)");
        System.out.println("  2. ✨ Create Account  (I'm new here)");
        System.out.println("  3. 🚪 Exit");
        System.out.println("========================================");
        System.out.print("  Enter your choice (1-3): ");
        return ConsoleReader.SCANNER.nextInt();
    }


    public void showError(String error){
        System.out.println(error);
    }

    public void showMessage(String message){
        System.out.println(message);
    }

}