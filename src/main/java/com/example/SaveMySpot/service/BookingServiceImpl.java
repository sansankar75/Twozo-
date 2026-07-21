package com.example.SaveMySpot.service;

import com.example.SaveMySpot.Enum.BookingStatus;
import com.example.SaveMySpot.entity.Booking;
import com.example.SaveMySpot.repo.BookingRepository;
import com.example.SaveMySpot.repo.BookingRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository = new BookingRepositoryImpl();

    @Override
    public Booking createBooking(Booking booking, List<Integer> seatIds) {
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
        bookingRepository.save(booking);
    }

    @Override
    public boolean checkAvailability(int showId) {
        return true;
    }

    @Override
    public List<Booking> getBookingsByUser(int userId) {
        return bookingRepository.getBookingsByUser(userId);
    }

    @Override
    public BigDecimal getTotalPrice(int bookingId) {
        return null;
    }

    @Override
    public Booking getBookingById(int bookingId) {
        return null;
    }

}