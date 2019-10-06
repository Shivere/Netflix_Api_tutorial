package com.cat.movie.MovieApiMockup.Controllers;

import com.cat.movie.MovieApiMockup.Repository.ActorRepository;
import com.cat.movie.MovieApiMockup.Repository.CategoryRepository;
import com.cat.movie.MovieApiMockup.Repository.MovieRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public CategoryController(CategoryRepository categoryRepository, MovieRepository movieRepository, ActorRepository actorRepository) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }
}
