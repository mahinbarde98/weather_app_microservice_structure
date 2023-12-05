package com.cts.registration.service;


import com.cts.registration.model.User;

import java.util.List;

public interface UserService {
     User signUp(User user);

     boolean validateUser(String username, String Password);

     public void init();

     List<User> allUsers();

}
