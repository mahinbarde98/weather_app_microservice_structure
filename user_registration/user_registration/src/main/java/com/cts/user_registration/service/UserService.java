package com.cts.user_registration.service;

import com.cts.user_registration.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    boolean validateUserService(String username,String password);

    boolean validateUser(String username, String password);



    User getByUsername(String username);
}
