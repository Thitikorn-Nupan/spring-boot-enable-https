package com.ttknp.springbootenablehttpscrudmysql.service;

import com.ttknp.springbootenablehttpscrudmysql.entity.Actor;

import java.util.Optional;


public interface ActorService {
    public Iterable<Actor> getAllActors();
    public Optional<Actor> getActor(Long aid);
    public Boolean addActor(Actor actor);
    public Boolean editActor(Actor actor,Long aid);
    public Boolean removeActor(Long aid);
}
