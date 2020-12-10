package com.el;

public class User {

    private Integer age;
    private String name;
    private Integer number;

    public User(Integer age, String name, Integer number) {
        this.age = age;
        this.name = name;
        this.number = number;
    }

    public User() {
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNam() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
