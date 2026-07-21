package com.example.SaveMySpot.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "status")
    private String Status = "Active";

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
    public String getStatus(){
        return this.Status;
    }
    public void setStatus(String Status){
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + (title != null ? title : "N/A") + '\'' +
                ", description='" + (description != null ? description : "N/A") + '\'' +
                ", duration=" + duration +
                ", language='" + (language != null ? language : "N/A") + '\'' +
                ", releaseDate=" + (releaseDate != null ? releaseDate : "N/A") +
                ", posterUrl='" + (posterUrl != null ? posterUrl : "N/A") + '\'' +
                ", movieStatus='" + (Status != null ? Status : "N/A") + '\'' +
                '}';
    }

}