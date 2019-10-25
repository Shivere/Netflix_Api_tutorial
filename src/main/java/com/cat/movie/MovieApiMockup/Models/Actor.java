package com.cat.movie.MovieApiMockup.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
//    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name")
//    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "year_born")
    private String yearBorn;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id_fk")
    private Movies movies;

//    public Actor(String name, String year, Movies movies){
//        this.name = name;
//        this.yearBorn = year;
//        this.movies = movies;
//    }


    public Actor(String name, String yearBorn) {
        this.name = name;
        this.yearBorn = yearBorn;
    }

    private Actor(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(String yearBorn) {
        this.yearBorn = yearBorn;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Movies getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearBorn='" + yearBorn + '\'' +
                ", movies=" + movies +
                '}';
    }

    public interface Create{}

    public interface Update{}
}
