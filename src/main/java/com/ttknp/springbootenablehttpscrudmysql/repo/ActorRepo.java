package com.ttknp.springbootenablehttpscrudmysql.repo;

import com.ttknp.springbootenablehttpscrudmysql.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepo extends CrudRepository<Actor, Long> {
}
