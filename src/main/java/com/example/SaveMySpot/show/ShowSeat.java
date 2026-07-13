package com.example.SaveMySpot.show;

import java.math.BigDecimal;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "show_seat")
public class ShowSeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_seat_id")
    private int showSeatId;

    @Column(name = "show_id", nullable = false)
    private int showId;

    @Column(name = "seat_id", nullable = false)
    private int seatId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShowRepositoryImpl.SeatStatus status;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    public int getShowSeatId() {
        return showSeatId;
    }
    public void setShowSeatId(int showSeatId) {
        this.showSeatId = showSeatId;
    }
    public int getShowId() {
        return showId;
    }
    public void setShowId(int showId) {
        this.showId = showId;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public ShowRepositoryImpl.SeatStatus getStatus() {
        return status;
    }
    public void setStatus(ShowRepositoryImpl.SeatStatus status) {
        this.status = status;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Entity
    @Table(name = "seat")
    public static class Seat implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "seat_id")
        private int seatId;

        @Column(name = "screen_id", nullable = false)
        private int screenId;

        @Column(name = "row_name")
        private String rowName;

        @Column(name = "seat_number")
        private int seatNumber;

        @Enumerated(EnumType.STRING)
        @Column(name = "seat_type")
        private SeatType seatType;

        public int getSeatId() {
            return seatId;
        }
        public void setSeatId(int seatId) {
            this.seatId = seatId;
        }
        public int getScreenId() {
            return screenId;
        }
        public void setScreenId(int screenId) {
            this.screenId = screenId;
        }
        public String getRowName() {
            return rowName;
        }
        public void setRowName(String rowName) {
            this.rowName = rowName;
        }
        public int getSeatNumber() {
            return seatNumber;
        }
        public void setSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
        }
        public SeatType getSeatType() {
            return seatType;
        }
        public void setSeatType(SeatType seatType) {
            this.seatType = seatType;
        }
    }

    public enum SeatType {
        SILVER,
        GOLD,
        PLATINUM,
        RECLINER
    }
}
