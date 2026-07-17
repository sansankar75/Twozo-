package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Actor;

import java.util.List;

public interface ActorRepository {

    void save(Actor actor);
    List<Actor> getAllActor();
    List<Actor> getActorByMovie();

}