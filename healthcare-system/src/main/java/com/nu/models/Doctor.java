package com.nu.models;

public class Doctor {

    private int id;
    private String name;
    private String specialty;
    private String email;
    private String password;
    private boolean availability;

    public Doctor(int id, String name, String specialty, boolean availability) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.availability = availability;
    }

    public Doctor() {
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + ", email=" + email + ", password="
                + password + ", availability=" + availability + ", getId()=" + getId() + ", getName()=" + getName()
                + ", getSpecialty()=" + getSpecialty() + ", isAvailability()=" + isAvailability() + ", getEmail()="
                + getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
}
