package com.nu.models;

public class Patient {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private double heartRate;
    private String ecgData;

    public Patient(int id, String name, int age, double heartRate, String ecgData) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.heartRate = heartRate;
        this.ecgData = ecgData;
    }

    public Patient(String name, int age, String email, String password) {

        this.name = name;

        this.age = age;

        this.email = email;

        this.password = password;

    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     // Getter and Setter for name
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public String getEcgData() {
        return ecgData;
    }

    public void setEcgData(String ecgData) {
        this.ecgData = ecgData;
    }

   

    

@Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password
                + ", heartRate=" + heartRate + ", ecgData=" + ecgData + ", getId()=" + getId() + ", getName()="
                + getName() + ", getAge()=" + getAge() + ", getHeartRate()=" + getHeartRate() + ", getEcgData()="
                + getEcgData() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}