package com.example.SaveMySpot.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "movie_genre")
public class MovieGenre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "movie_id")
    private int movieId;

    public int getGenreId() {
        return genreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movie_id) {
        this.movieId = movie_id;
    }

    public void setGenreId(int genre_id) {
        this.genreId = genre_id;
    }
}
