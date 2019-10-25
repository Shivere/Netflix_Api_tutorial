package com.cat.movie.MovieApiMockup;

import com.cat.movie.MovieApiMockup.Models.Actor;
import com.cat.movie.MovieApiMockup.Models.Movies;
import com.cat.movie.MovieApiMockup.Models.User;
import com.cat.movie.MovieApiMockup.Repository.ActorRepository;
import com.cat.movie.MovieApiMockup.Repository.MovieRepository;
import com.cat.movie.MovieApiMockup.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyData implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ActorRepository actorRepository;

    public DummyData(MovieRepository movieRepository, UserRepository userRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (movieRepository.findAll().isEmpty()){
            movieRepository.save(new Movies("Bomboclaat","2019","Original"));
            movieRepository.save(new Movies("Ballers","2015","Original"));
            movieRepository.save(new Movies("Bloodclaat","2019","Original"));
        }
        if (userRepository.findAll().isEmpty()){
            userRepository.save(new User((long) 95625, "Shivere"));
        }
        if(actorRepository.findAll().isEmpty()){
            actorRepository.save((new Actor("De jong","1980")));
        }

        System.out.println("Movies: "+movieRepository.findAll());
        System.out.println("Actors: " + actorRepository.findAll());
        System.out.println("Users: "+userRepository.findAll());

    }
}
