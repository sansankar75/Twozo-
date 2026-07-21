package com.example.SaveMySpot.view;

import com.example.SaveMySpot.Enum.SeatType;
import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.Screen;
import com.example.SaveMySpot.entity.Seat;
import com.example.SaveMySpot.entity.ShowSeat;
import com.example.SaveMySpot.entity.Theater;

import java.util.List;

public class TheaterView {

    public Theater addTheater() {
        Theater theater = new Theater();

        System.out.println("\n==========================================");
        System.out.println("                THEATER                     ");
        System.out.println("==========================================");
        System.out.print("Theater Name : ");
        theater.setName(ConsoleReader.SCANNER.nextLine());
        System.out.print("Location     : ");
        theater.setAddress(ConsoleReader.SCANNER.nextLine());
        System.out.print("Address      : ");
        theater.setAddress(ConsoleReader.SCANNER.nextLine());
        System.out.println("==========================================\n");

        return theater;
    }

    public Screen addScreen() {
        Screen screen = new Screen();

        System.out.println("\n==========================================");
        System.out.println("                 SCREEN                     ");
        System.out.println("==========================================");
        System.out.print("Screen Name  : ");
        screen.setScreenName(ConsoleReader.SCANNER.nextLine());
        System.out.print("Capacity     : ");
        screen.setTotalSeats(ConsoleReader.SCANNER.nextInt());
        System.out.println("==========================================\n");

        return screen;
    }

    public Seat addSeat() {
        Seat seat = new Seat();
        ShowSeat showSeat = new ShowSeat();

        System.out.println("\n==========================================");
        System.out.println("                  SEAT                    ");
        System.out.println("==========================================");
        System.out.print("Seat Number  : ");
        seat.setSeatNumber(ConsoleReader.SCANNER.nextInt());
        System.out.print("Seat Type    : ");
        seat.setSeatType(SeatType.valueOf(ConsoleReader.SCANNER.nextLine()));
        System.out.print("Price        : ");
        showSeat.setPrice(ConsoleReader.SCANNER.nextBigDecimal());
        System.out.println("==========================================\n");

        return seat;
    }

    public int selectTheater() {
        System.out.println("\n==========================================");
        System.out.print("Enter Theater ID : ");
        return Integer.parseInt(ConsoleReader.SCANNER.nextLine());
    }

    public void displayTheaters(List<Theater> theaters) {
        System.out.println("\n==========================================");
        System.out.println("             THEATER  LIST              ");
        System.out.println("==========================================");
        if (theaters == null || theaters.isEmpty()) {
            System.out.println("No theater available.");
            return;
        }
        System.out.printf("%-5s %-25s %-20s%n", "ID", "Name", "Location");
        System.out.println("-----------------------------------------------------");
        for (Theater theater : theaters) {
            System.out.printf("%-5d %-25s %-20s%n",
                       theater.getTheaterId(),
                    theater.getName(),
                    theater.getAddress());
        }
        System.out.println("==========================================");
    }

    public void showMessage(String message){
        System.out.println(message);
    }

}