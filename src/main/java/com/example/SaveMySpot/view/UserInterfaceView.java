package com.example.SaveMySpot.view;

import com.example.SaveMySpot.common.ConsoleReader;

public class UserInterfaceView {

    public int show() {

        System.out.println("\n==========================================");
        System.out.println("              USER DASHBOARD");
        System.out.println("==========================================");
        System.out.println("1. View Movies");           //✅
        System.out.println("2. Book Movie Ticket");
        System.out.println("3. Booking History");
        System.out.println("4. Cancel Booking");
        System.out.println("5. View Profile");
        System.out.println("6. Logout");
        System.out.println("==========================================");
        System.out.print("Enter Choice : ");

        return ConsoleReader.SCANNER.nextInt();
    }


    public void showMessage(String message){
        System.out.println(message);
    }

}