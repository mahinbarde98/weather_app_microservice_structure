package com.cts.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Arrays;

@Entity
public class User {
    @Id
    String username;
    String password;
    String name;
    String[] role;

    public User(String username, String password, String name, String[] role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + Arrays.toString(role) +
                '}';
    }
}
