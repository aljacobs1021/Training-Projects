package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ers_users")
public class User {
    // private int id;
    // private String first; //first name
    // private String last; //last name
    // private String username;
    // private String email;
    // private String pass; //password

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String first; // first name

    @Column(name = "last_name", nullable = false)
    private String last; // last name

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String pass; // password

    @OneToMany(mappedBy = "employee_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reimbursement> employees = new ArrayList<Reimbursement>();

    @OneToMany(mappedBy = "manager_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reimbursement> manager = new ArrayList<Reimbursement>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private URoles role; // account type: manager or employee

    public User() {
        super();
    }

    public User(String firstName, String lastName, String email, String username, String password, URoles role) {
        super();
        this.first = firstName;
        this.last = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.pass = password;
        this.role = role;
    }

    public User(int id, String firstName, String lastName, String email, String username, String password,
            URoles role) {
        super();
        this.id = id;
        this.first = firstName;
        this.last = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.pass = password;
        this.role = role;
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

    public void setRole(URoles role) {
        this.role = role;
    }

    public URoles getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", first=" + first + ", id=" + id + ", last=" + last + ", pass=" + pass
                + ", role=" + role + ", username=" + username + "]";
    }

}