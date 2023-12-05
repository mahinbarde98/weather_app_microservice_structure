package com.cts.user_authentication.model;

import java.util.Arrays;

public class JwtResponse {
String token;


    public JwtResponse(String token){
        this.token = token;

    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    @Override
    public String toString() {
        return "JwtResponse{" +

                '}';
    }
}
