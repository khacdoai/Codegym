package com.example.demo.model;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private double point;

    public Student(int id, String name, boolean gender, double point) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
    }

    public Student(String name, boolean gender, double point) {
        this.name = name;
        this.gender = gender;
        this.point = point;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
