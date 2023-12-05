package com.cts.user_authentication.service;


import com.cts.user_authentication.model.UserCredentials;

public interface UserService {
     UserCredentials saveDetails(UserCredentials user);

     boolean validateUser(String username, String Password);

     public void init();

}
