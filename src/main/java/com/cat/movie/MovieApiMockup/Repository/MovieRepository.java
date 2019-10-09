package com.cat.movie.MovieApiMockup.Repository;

import com.cat.movie.MovieApiMockup.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movies, Long> {
    Optional<Movies> findMovieByType (String type);
    Optional<Movies> findMoviesByName (String name);
    Optional<Movies> findMoviesByYearReleased(String yearReleased);
    Optional<Movies> findMoviesByNameAndYearReleased(String name, String yearReleased);
}
