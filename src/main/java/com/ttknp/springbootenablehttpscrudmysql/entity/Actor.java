package com.ttknp.springbootenablehttpscrudmysql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long actorId;
    private String actorName;
    private Long actorFollowing;

    public Actor() {
    }

    public Actor(Long actorId, String actorName, Long actorFollowing) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.actorFollowing = actorFollowing;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Long getActorFollowing() {
        return actorFollowing;
    }

    public void setActorFollowing(Long actorFollowing) {
        this.actorFollowing = actorFollowing;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", actorName='" + actorName + '\'' +
                ", actorFollowing=" + actorFollowing +
                '}';
    }
}