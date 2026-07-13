package com.example.SaveMySpot.admin;

import com.example.SaveMySpot.common.ConsoleReader;

public class AdminView {

    public int showMenu() {

        System.out.println("\n==========================================");
        System.out.println("             ADMIN DASHBOARD");
        System.out.println("==========================================");
        System.out.println("1. Add Movie");
        System.out.println("2. Update Movie");
        System.out.println("3. Delete Movie");
        System.out.println("------------------------------------------");
        System.out.println("4. Add Theater");
        System.out.println("5. Add Screen");
        System.out.println("6. Add Seat");
        System.out.println("------------------------------------------");
        System.out.println("7. Create Show");
        System.out.println("8. Update Show");
        System.out.println("9. Delete Show");
        System.out.println("------------------------------------------");
        System.out.println("0. Logout");
        System.out.println("==========================================");
        System.out.print("Enter Choice : ");

        return ConsoleReader.SCANNER.nextInt();
    }
    public void showMessage(String message) {
        System.out.println("\n[SUCCESS ] " + message);
    }
    public void showError(String message) {
        System.out.println("\n[ERROR] " + message);
    }
    public boolean confirmAction() {
        System.out.print("Are you sure? (Y/N): ");

        String choice = ConsoleReader.SCANNER.nextLine().trim();
        return choice.equalsIgnoreCase("Y");
    }

}