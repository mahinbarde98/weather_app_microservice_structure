package com.cts.registration.service;


import com.cts.registration.model.User;
import com.cts.registration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(User user) {
        if(user!=null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean validateUser(String username, String password) {
        User user = userRepository.ValideUser(username,password);
        System.out.println("user :" + user );
        if (user!=null){return true;}
        return false;
    }

    @Override
    public void init() {
        User user1 = new User("admin","admin","admin",new String[]{"admin"});
        User user2 = new User("user","user","user",new String[]{"user"});
        userRepository.save(user1);
        userRepository.save(user2);

    }

    @Override
    public List<User> allUsers() {
        List<User> userList = userRepository.findAll();
        return  userList;
    }


}
