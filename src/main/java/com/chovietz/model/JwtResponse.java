package com.chovietz.model;


public class JwtResponse {

    private final String jwttoken;
    private String userRole;

    public JwtResponse(String jwttoken, String userRole) {
        this.jwttoken = jwttoken;
        this.userRole = userRole;
    }

    public String getToken() {
        return this.jwttoken;
    }
    public String getUserRole() {
    	return this.userRole;
    }
}