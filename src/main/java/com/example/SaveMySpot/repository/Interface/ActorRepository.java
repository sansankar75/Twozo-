package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Actor;

import java.util.List;

public interface ActorRepository {

    void save(Actor actor);
    List<Actor> findAll();

}