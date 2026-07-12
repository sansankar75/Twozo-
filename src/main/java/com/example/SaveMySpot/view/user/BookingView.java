package com.example.SaveMySpot.view.user;

import com.example.SaveMySpot.model.Booking;
import com.example.SaveMySpot.util.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class BookingView {

    public int selectMovie() {
        System.out.println("\n==========================================");
        System.out.print("Enter Movie ID : ");
        return Integer.parseInt(ConsoleReader.SCANNER.nextLine());
    }

    public int selectShow() {
        System.out.println("\n==========================================");
        System.out.print("Enter Show ID : ");
        return Integer.parseInt(ConsoleReader.SCANNER.nextLine());
    }

    public List<Integer> selectSeats() {
        List<Integer> seatIds = new ArrayList<>();

        System.out.println("\n==========================================");
        System.out.println("Enter Seat IDs (0 to Finish)");
        System.out.println("==========================================");

        while (true) {
            System.out.print("Seat ID : ");
            int seatId = Integer.parseInt(ConsoleReader.SCANNER.nextLine());
            if (seatId == 0) {
                break;
            }
            seatIds.add(seatId);
        }
        return seatIds;
    }

    public Booking showBooking() {
        Booking booking = new Booking();

        System.out.println("\n==========================================");
        System.out.println("              BOOKING");
        System.out.println("==========================================");
        System.out.print("User ID : ");
        booking.setUserId(Integer.parseInt(ConsoleReader.SCANNER.nextLine()));
        System.out.print("Show ID : ");
        booking.setShowId(Integer.parseInt(ConsoleReader.SCANNER.nextLine()));
        System.out.println("==========================================");

        return booking;
    }

    public void displayTicket(Booking booking) {

        System.out.println("\n==========================================");
        System.out.println("           BOOKING TICKET");
        System.out.println("==========================================");
        System.out.println("Booking ID : " + booking.getBookingId());
        System.out.println("User ID    : " + booking.getUserId());
        System.out.println("Show ID    : " + booking.getShowId());
        System.out.println("Status     : " + booking.getBookingStatus());
        System.out.println("Booked On  : " + booking.getBookingDate());

        System.out.println("==========================================");
    }

    public void displayBookings(List<Booking> bookings) {

        System.out.println("\n========================================================");
        System.out.println("                 BOOKING HISTORY");
        System.out.println("========================================================");
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.printf("%-8s %-8s %-8s %-15s%n",
                "ID", "User", "Show", "Status");
        System.out.println("--------------------------------------------------------");
        for (Booking booking : bookings) {

            System.out.printf("%-8d %-8d %-8d %-15s%n",
                    booking.getBookingId(),
                    booking.getUserId(),
                    booking.getShowId(),
                    booking.getBookingStatus());
        }
        System.out.println("========================================================");
    }

    public void showError(String error){
        System.out.println("We are sorry to say this: " + error);
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}