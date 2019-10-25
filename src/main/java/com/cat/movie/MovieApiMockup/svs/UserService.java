package com.cat.movie.MovieApiMockup.svs;

import com.cat.movie.MovieApiMockup.Models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User createUser(User user);
}
