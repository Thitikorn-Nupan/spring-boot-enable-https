package com.ttknp.springbootenablehttpscrudmysql.dto;

import com.ttknp.springbootenablehttpscrudmysql.entity.Actor;
import com.ttknp.springbootenablehttpscrudmysql.repo.ActorRepo;
import com.ttknp.springbootenablehttpscrudmysql.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorDto implements ActorService {
    private ActorRepo actorRepo;

    @Autowired
    public ActorDto(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    public Iterable<Actor> getAllActors() {
        return actorRepo.findAll();
    }

    @Override
    public Optional<Actor> getActor(Long aid) {
        return actorRepo.findById(aid);
    }

    @Override
    public Boolean addActor(Actor actor) {
        return actorRepo.save(actor).getActorId() != null;
    }

    @Override
    public Boolean editActor(Actor actor, Long aid) {
        return actorRepo.findById(aid).map(actorByPk -> {
            actorByPk.setActorName(actor.getActorName());
            actorByPk.setActorFollowing(actor.getActorFollowing());
            return actorRepo.save(actorByPk).getActorId() != null;
        }).orElse(false);
    }

    @Override
    public Boolean removeActor(Long aid) {
        return actorRepo.findById(aid).map(actorByPk -> {
            actorRepo.delete(actorByPk);
            return true;
        }).orElse(false);
    }
}
