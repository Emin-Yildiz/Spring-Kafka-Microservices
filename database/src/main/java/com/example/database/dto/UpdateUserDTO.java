package com.example.database.dto;

public class UpdateUserDTO {

    private Long id;
    private String job;

    public UpdateUserDTO(Long id, String job) {
        this.id = id;
        this.job = job;
    }

    public UpdateUserDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
