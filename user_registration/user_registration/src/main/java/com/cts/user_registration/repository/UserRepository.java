package com.cts.user_registration.repository;

import com.cts.user_registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

//    @Query(value="select u from User u where u.userId :username and u.userPassword :password")
//    Optional<User> validateUser(@Param("userId") String userId, @Param("userPassword") String userPassword);

    User findByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.username= :username and u.password= :password")
    User ValideUser(@Param("username") String username,@Param("password") String password);
}
