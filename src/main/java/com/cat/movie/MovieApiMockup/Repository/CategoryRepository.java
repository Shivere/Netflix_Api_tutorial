package com.cat.movie.MovieApiMockup.Repository;

import com.cat.movie.MovieApiMockup.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
