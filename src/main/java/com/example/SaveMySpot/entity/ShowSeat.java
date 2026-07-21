package com.example.SaveMySpot.entity;

import java.math.BigDecimal;

import com.example.SaveMySpot.Enum.SeatType;
import com.example.SaveMySpot.repo.ShowRepositoryImpl;
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

    @Column(name = "status")
    private String status;

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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
