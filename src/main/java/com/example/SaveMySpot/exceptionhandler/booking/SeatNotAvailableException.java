package com.example.SaveMySpot.exceptionhandler.booking;

public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
