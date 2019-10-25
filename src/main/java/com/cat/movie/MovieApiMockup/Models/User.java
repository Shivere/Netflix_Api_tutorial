package com.cat.movie.MovieApiMockup.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
//    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "idNumber")
    private Long idNumber;
//    @NotNull(groups = Create.class)
    private String name;

    public User(Long idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public User(){

    }

    public Long getId() {
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

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idNumber=" + idNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public interface Create{}

    public interface Update{}
}
