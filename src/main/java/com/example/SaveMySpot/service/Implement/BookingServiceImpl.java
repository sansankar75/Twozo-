package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.enums.BookingStatus;
import com.example.SaveMySpot.model.Booking;
import com.example.SaveMySpot.repository.Implement.BookingRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.BookingRepository;
import com.example.SaveMySpot.service.Interface.BookingService;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository = new BookingRepositoryImpl();

    @Override
    public Booking createBooking(Booking booking) {

        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null.");
        }

        booking.setBookingStatus(BookingStatus.CONFIRMED);

        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public void cancelBooking(int bookingId) {

        Booking booking = bookingRepository.findById(bookingId);

        if (booking == null) {
            throw new RuntimeException("Booking not found.");
        }

        booking.setBookingStatus(BookingStatus.CANCELLED);

        // No repository update() exists, so save again
        bookingRepository.save(booking);
    }

    @Override
    public boolean checkAvailability(int showId) {

        // Availability logic will be implemented later.
        return true;
    }
}