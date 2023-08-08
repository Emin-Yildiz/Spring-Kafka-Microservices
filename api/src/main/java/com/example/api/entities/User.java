package com.example.api.entities;

public class User {

    // id kullanmasan ve veritabanına kayıt ederken id ataması yapsam nasıl olur.
    //private long id;
    private String name;
    private int age;
    private String job;

//    public User(long id, String name, int age, String job) {
//        //this.id = id;
//        this.name = name;
//        this.age = age;
//        this.job = job;
//    }

    public User(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    public User(){}

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
