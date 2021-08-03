package com.example.models;

public enum Type {
    LODGING("Lodging"), TRAVEL("Travel"), FOOD("Food"), OTHER("Other");
    private String type;
    Type(String type) {
        this.type = type;
    }
    public String getStatus() {
        return type;
    }    
}