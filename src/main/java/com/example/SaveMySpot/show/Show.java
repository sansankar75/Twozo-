package com.example.SaveMySpot.show;

import java.util.Date;
import java.sql.Time;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "show")
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private int showId;

    @Column(name = "screen_id", nullable = false)
    private int screenId;

    @Column(name = "movie_id", nullable = false)
    private int movieId;

    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "start_time")
    private Time startTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShowStatus status;

    public int getShowId() {
        return showId;
    }
    public void setShowId(int showId) {
        this.showId = showId;
    }
    public int getScreenId() {
        return screenId;
    }
    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public Date getShowDate() {
        return showDate;
    }
    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
    public Time getStartTime() {
        return startTime;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    public ShowStatus getStatus() {
        return status;
    }
    public void setStatus(ShowStatus status) {
        this.status = status;
    }
}
