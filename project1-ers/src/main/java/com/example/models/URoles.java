package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_user_roles")
public class URoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private int id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Roles role;

    public URoles() {

    }

    public URoles(int id, Roles role) {
        super();
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public Roles getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "URoles [id=" + id + ", role=" + role + "]";
    }

}
