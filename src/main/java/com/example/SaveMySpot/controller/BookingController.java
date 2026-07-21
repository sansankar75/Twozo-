package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.repo.BookingSeatRepository;
import com.example.SaveMySpot.service.BookingService;
import com.example.SaveMySpot.service.BookingServiceImpl;
import com.example.SaveMySpot.view.BookingView;
import com.example.SaveMySpot.entity.Booking;

import java.math.BigDecimal;
import java.util.List;

public class BookingController {
    private final BookingView bookingView;
    private final BookingService bookingService;
    private final BookingSeatRepository bookingSeatRepository;

    public BookingController(BookingView bookingView,
                             BookingService bookingService,
                             BookingSeatRepository bookingSeatRepository) {

        this.bookingView = bookingView;
        this.bookingService = bookingService;
        this.bookingSeatRepository = bookingSeatRepository;
    }

    public Booking createBooking(Booking booking) {
        if (!bookingService.checkAvailability(booking.getShowId())) {
            bookingView.showError("Seats are not available.");
            return null;
        }

        List<Integer> seatIds = bookingView.selectSeats();

        if (seatIds.isEmpty()) {
            bookingView.showMessage("No seats selected. Booking cancelled.");
            return null;
        }

        Booking savedBooking = bookingService.createBooking(booking, seatIds);

        if (savedBooking == null) {
            bookingView.showError("Unable to create booking.");
            return null;
        }

        bookingView.showMessage("Booking created successfully.");
        bookingView.displayTicket(savedBooking);

        return savedBooking;
    }

    public void cancelBooking(int bookingId) {
        bookingService.cancelBooking(bookingId);
        bookingView.showMessage("Booking cancelled successfully.");
    }

    public boolean checkAvailability(int showId) {
        return bookingService.checkAvailability(showId);
    }

    public void viewBookingHistory(int userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);
        bookingView.displayBookings(bookings);
    }

    public BigDecimal getTotalPrice(int bookingId) {
        return bookingService.getTotalPrice(bookingId);
    }

    public Booking getBookingById(int bookingId) {
        return bookingService.getBookingById(bookingId);
    }
}