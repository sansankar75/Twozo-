package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Booking;
import com.example.SaveMySpot.service.Implement.BookingServiceImpl;
import com.example.SaveMySpot.service.Interface.BookingService;
import com.example.SaveMySpot.view.user.BookingView;

public class BookingController {

    private final BookingView bookingView;
    private final BookingService bookingService;

    public BookingController() {
        bookingView = new BookingView();
        bookingService = new BookingServiceImpl();
    }

    public Booking createBooking(Booking booking) {

        if (!bookingService.checkAvailability(booking.getShowId())) {
            bookingView.showError("Seats are not available.");
            return null;
        }

        Booking savedBooking = bookingService.createBooking(booking);

        bookingView.showMessage("Booking created successfully.");

        return savedBooking;
    }

    public void cancelBooking(int bookingId) {
        bookingService.cancelBooking(bookingId);
        bookingView.showMessage("Booking cancelled successfully.");
    }

    public boolean checkAvailability(int showId) {
        return bookingService.checkAvailability(showId);
    }
}