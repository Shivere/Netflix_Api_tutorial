package com.cat.movie.MovieApiMockup.Controllers;

import com.cat.movie.MovieApiMockup.Models.Actor;
import com.cat.movie.MovieApiMockup.NotFoundException;
import com.cat.movie.MovieApiMockup.Repository.ActorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "actors")
public class ActorController {
    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public List<Actor> getAllActors(@PathVariable Long id, @RequestParam String name){
        Actor actor = actorRepository.findActorByName(name)
                .orElseThrow(() -> new NotFoundException("Actor not found"));
        return actorRepository.findAll();
    }
}
