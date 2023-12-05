package com.cts.registration.controller;

import com.cts.registration.model.User;
import com.cts.registration.repository.UserRepository;
import com.cts.registration.service.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserServiceImpl userService ,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository=userRepository;
    }

    @PostConstruct
    void users(){
        userService.init();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        User user1 = userService.signUp(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestBody User user){
        User user1 = userService.signUp(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

//    @GetMapping("/validate")
//    public ResponseEntity<?> validateUser(@RequestParam String username,@RequestParam String password){
//       // boolean user1 = userService.validateUser(user.getUsername(),user.getPassword());
//        boolean user1 = userService.validateUser(username, password);
//        return new ResponseEntity<>(user1, HttpStatus.OK);
//    }
    @GetMapping("/validate")
    public boolean validateUser(@RequestParam String username,@RequestParam String password){
        // boolean user1 = userService.validateUser(user.getUsername(),user.getPassword());
        boolean user1 = userService.validateUser(username, password);
        return user1;
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUsers(){
        // boolean user1 = userService.validateUser(user.getUsername(),user.getPassword());
        List<User> userList = userService.allUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

}
