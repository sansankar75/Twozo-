package com.example.SaveMySpot.actor;

import java.util.List;

public interface ActorRepository {

    void save(Actor actor);
    List<Actor> findAll();

}