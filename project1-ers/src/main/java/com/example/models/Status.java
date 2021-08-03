package com.example.models;

public enum Status {
    SUBMITTED("Submitted"), DENIED("Denied"), APPROVED("Approved");
    private String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}