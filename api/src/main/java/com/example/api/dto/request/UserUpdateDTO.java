package com.example.api.dto.request;

public class UserUpdateDTO {

    private String job;
    private Long id;

    public UserUpdateDTO(String job,Long id){
        this.job = job;
        this.id = id;
    }

    public UserUpdateDTO(){}

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}