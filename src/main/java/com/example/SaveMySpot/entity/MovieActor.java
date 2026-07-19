package com.example.SaveMySpot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_actor")
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "movie_id")
    private int movieId;


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getActorId() {
        return actorId;
    }

    public int getMovieId() {
        return movieId;
    }
}
