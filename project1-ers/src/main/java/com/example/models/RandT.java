package com.example.models;

public class RandT {
    public enum ROLES {
        EMPLOYEE("Employee"), MANAGER("Manager");
        private String role;
        ROLES(String role) {
            this.role = role;
        }

        
    }

    public enum TYPE {
        LODGING("Lodging"), TRAVEL("Travel"), FOOD("Food"), OTHER("Other");
        private String type;
        TYPE(String type) {
            this.type = type;
        }
    }
}