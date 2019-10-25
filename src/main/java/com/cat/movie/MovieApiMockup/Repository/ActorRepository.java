package com.cat.movie.MovieApiMockup.Repository;

import com.cat.movie.MovieApiMockup.Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<Actor> findActorByName(String name);
}
