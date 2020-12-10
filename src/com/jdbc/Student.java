package com.jdbc;

public class Student {
    public Student(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public Student(Integer id, String name, String school, String t1, String t2) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", t1='" + t1 + '\'' +
                ", t2='" + t2 + '\'' +
                '}';
    }

    private Integer id;
    private String name;
    private String school;
    private String t1;
    private String t2;


}
