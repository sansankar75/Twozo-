package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Actor;

import java.util.List;

public interface ActorRepository {

    void save(Actor actor);
    List<Actor> getAllActor();
    List<Actor> getActorsByMovie(int movie_id);
    Actor findById(int actorId);
    List<Actor> searchActorByName(String name);
    void update(Actor actor);
    void delete(int actorId);
}