package com.example.myapplication;

public class studentModel {
    private int roll;
    private String name;
    private int phone;
    private int age;

    public studentModel(int roll, String name, int phone, int age) {
        this.roll = roll;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "studentModel{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
