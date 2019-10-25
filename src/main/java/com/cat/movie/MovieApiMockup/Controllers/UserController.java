package com.cat.movie.MovieApiMockup.Controllers;

import com.cat.movie.MovieApiMockup.Models.User;
import com.cat.movie.MovieApiMockup.svs.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
//    private final UserRepository userRepository;
//    private final UserService userService;
//
//    public UserController(UserRepository userRepository, UserService userService) {
//        this.userRepository = userRepository;
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public User register(@RequestBody User user){
//        if (user.getIdNumber() == null &&
//        user.getName() == null)
//            throw new InvalidInputException("Either ID number or name is missing");
//            Optional<User> u = userRepository.findByIdNumberAndName(user.getIdNumber(),user.getName());
//
//        return u.orElseGet(() -> userService.createUser(user));
//    }
}
