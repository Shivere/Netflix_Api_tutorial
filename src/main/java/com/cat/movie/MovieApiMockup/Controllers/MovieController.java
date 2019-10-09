package com.cat.movie.MovieApiMockup.Controllers;

import com.cat.movie.MovieApiMockup.InvalidInputException;
import com.cat.movie.MovieApiMockup.Models.Category;
import com.cat.movie.MovieApiMockup.Models.Movies;
import com.cat.movie.MovieApiMockup.NotFoundException;
import com.cat.movie.MovieApiMockup.Repository.CategoryRepository;
import com.cat.movie.MovieApiMockup.Repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public Movies suggest(@RequestBody Movies movies){
        if (movies.getName() == null ||
        movies.getYearReleased() == null)
            throw new InvalidInputException("Either Name or Year released is missing");
        Optional<Movies> m = movieRepository.findMoviesByNameAndYearReleased(movies.getName(),movies.getYearReleased());
        if (!m.isPresent()){
            return movieRepository.save(movies);
        }else
            return m.get();
    }

}
