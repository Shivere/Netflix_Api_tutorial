package com.cat.movie.MovieApiMockup.Controllers;

import com.cat.movie.MovieApiMockup.Models.Category;
import com.cat.movie.MovieApiMockup.Models.Movies;
import com.cat.movie.MovieApiMockup.NotFoundException;
import com.cat.movie.MovieApiMockup.Repository.CategoryRepository;
import com.cat.movie.MovieApiMockup.Repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public MovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Movies>getAllMovies(@PathVariable Long id, @RequestParam String type){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CategoryId not found"));

        Movies movies = movieRepository.findMovieByType(type)
                .orElseThrow(() -> new NotFoundException("Movie not found"));

        return movieRepository.findAll();
    }
}
