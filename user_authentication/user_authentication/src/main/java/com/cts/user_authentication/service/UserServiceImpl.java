package com.cts.user_authentication.service;




import com.cts.user_authentication.model.UserCredentials;
import com.cts.user_authentication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JwtService jwtService;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCredentials saveDetails(UserCredentials user) {
        if(user!=null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean validateUser(String username, String password) {
        UserCredentials user = userRepository.ValideUser(username,password);
        System.out.println("user :" + user );
        if (user!=null){return true;}
        return false;
    }

    public void init() {
        UserCredentials user1 = new UserCredentials("admin","admin");
        UserCredentials user2 = new UserCredentials("user","user");
        userRepository.save(user1);
        userRepository.save(user2);

    }

//    @Autowired
//    FeignService feignService;
//    public boolean validateUser(@RequestParam String username, @RequestParam String password){
//
//        boolean user1 =feignService.validateUser(username,password);
//        return user1;
//    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }



}
