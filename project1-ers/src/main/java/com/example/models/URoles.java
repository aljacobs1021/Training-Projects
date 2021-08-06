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
    private int id;
    private Roles role;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    public int getId() {
        return id;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    public Roles getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public URoles(int id, Roles role) {
        this.id = id;
        this.role = role;
    }

}
