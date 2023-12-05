package com.cts.user_registration.controller;


import com.cts.user_registration.entity.User;
import com.cts.user_registration.exception.UserAlreadyExistException;
import com.cts.user_registration.service.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("register")
public class UserController {

    public UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        super();
        this.userService = userService;
    }

    @PostConstruct
    public  void initUsers(){
        userService.init();
    }

    @PostMapping("/save")
    public ResponseEntity<?> registerUser(@RequestBody User user){

        try{

            if(user!=null) {
                String username = user.getUsername();
                String password = user.getPassword();
                System.out.println("userCredentials: " + username + " " + password);
                User newUser = userService.saveUser(user);
                userService.sendUserCredentials(username, password);

                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            }
            else {
                throw new UserAlreadyExistException("User Data is already registered with the system");
            }

        }catch (UserAlreadyExistException e){
            return new ResponseEntity<String>("Check the user data",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUsers(){

            List<User> userList =userService.getAllUsers();
            return new ResponseEntity<>(userList,HttpStatus.OK);

    }


//    public boolean validateUser(@RequestBody String username , String password){
//
//       if(userService.validateUser(username,password))
//       {
//           return true;
//       }
//        return false;
//    }
//    @GetMapping("/validate")
//    public User getUserByUername(@RequestBody String username){
//        User user = userService.getByUsername(username);
//        System.out.println("User : " +user);
//        return  user;
//    }
//    @PostMapping("/login")
//    public JwtResponse logIn(@RequestBody JwtRequest jwtRequest) throws ServletException {
//        String username =jwtRequest.getUsername();
//        String password = jwtRequest.getPassword();
//        String jwtToken;
//        //List<Role> role;
//        String [] role ={"admin"};
//        if(username ==null || password ==null)
//        {
//            throw new ServletException("Please enter valid credentials");
//        }
//
//
//
//        // boolean flag = userService.validateUser(username,password);
//        boolean flag =userService.validateUser(username,password);
//        System.out.println(flag);
//
//
//        if(!flag)
//        {
//            throw new ServletException("Invalid credentials");
//        }
//
//        return userService.generateToken(jwtRequest);
//    }

}
