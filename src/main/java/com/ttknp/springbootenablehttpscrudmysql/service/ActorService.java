package com.ttknp.springbootenablehttpscrudmysql.service;

import com.ttknp.springbootenablehttpscrudmysql.entity.Actor;

import java.util.Optional;


public interface ActorService {
    Iterable<Actor> getAllActors();
    Optional<Actor> getActor(Long aid);
    Boolean addActor(Actor actor);
    Boolean editActor(Actor actor,Long aid);
    Boolean removeActor(Long aid);
}
