package com.cts.user_authentication.controller;

import com.cts.user_authentication.model.JwtRequest;
import com.cts.user_authentication.model.JwtResponse;

import com.cts.user_authentication.model.UserCredentials;
import com.cts.user_authentication.repository.UserRepository;
import com.cts.user_authentication.service.JwtService;
import com.cts.user_authentication.service.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authservice")
public class AuthenticationController {

    private final UserServiceImpl userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationController(UserServiceImpl userService, UserRepository userRepository, JwtService jwtService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostConstruct
    void users() {
        userService.init();
    }

    @PostMapping("/auth")
    public JwtResponse logIn(@RequestBody JwtRequest jwtRequest) throws ServletException {
        return jwtService.generateToken(jwtRequest);
    }



//    @PostMapping("/register")
//    public void registerUserdetails (@RequestBody  String username, String password){
//        UserCredentials userCredentials = new UserCredentials();
//        userCredentials.setUsername(username);
//        userCredentials.setPassword(password);
//        userRepository.save(userCredentials);
//        System.out.println("userService.saveDetails(userCredentials)  :"
//                +userRepository.save(userCredentials));
//    }

    @PostMapping("/register")
    public void registerUserdetails (@RequestBody UserCredentials userCredentials){

        userRepository.save(userCredentials);
        System.out.println("User Cedentials  :"
                +userRepository.save(userCredentials));
    }

    @PostMapping("/validate")
    public String valiateToken (@RequestParam("token") String token){
        userService.validateToken(token);

       return  "Token Validated";
    }
}

