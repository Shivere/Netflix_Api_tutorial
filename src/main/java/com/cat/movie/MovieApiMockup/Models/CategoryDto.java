package com.cat.movie.MovieApiMockup.Models;

public class CategoryDto {
    private Long MovieId;
    private Long ActorId;

    public Long getMovieId() {
        return MovieId;
    }

    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }

    public Long getActorId() {
        return ActorId;
    }

    public void setActorId(Long actorId) {
        ActorId = actorId;
    }
}
