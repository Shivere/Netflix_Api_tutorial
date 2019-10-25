package com.cat.movie.MovieApiMockup.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
//    @NotNull(groups = Update.class)
    private Long movie_id;

    @Column(name = "name")
//    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "year_released")
    private String yearReleased;

    @Column(name = "type")
    private String type;

    public Movies(String name, String yearReleased, String type) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.type = type;
    }

    private Movies(){

    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    @JsonIgnore
    @OneToMany(mappedBy = "movies")
    private List<Actor> actors;
//
//    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    @Override
    public String toString() {
        return "Movies{" +
                "movie_id=" + movie_id +
                ", name='" + name + '\'' +
                ", yearReleased='" + yearReleased + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public interface Create{}

    public interface Update{}
}
