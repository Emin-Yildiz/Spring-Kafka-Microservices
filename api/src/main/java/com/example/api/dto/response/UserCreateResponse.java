package com.example.api.dto.response;

public class UserCreateResponse {

    private String name;

    public UserCreateResponse(String name){
        this.name = name;
    }

    public UserCreateResponse(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
