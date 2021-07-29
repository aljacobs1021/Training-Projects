package com.example.models;

public class User {
    private int id;
    private String first; //first name
    private String last; //last name
    private String username;
    private String email;
    private String pass; //password
    private String role; //account type: manager or employee

    public User() {

    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return this.first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return this.last;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}