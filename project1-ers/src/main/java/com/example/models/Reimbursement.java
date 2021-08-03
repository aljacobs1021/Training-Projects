package com.example.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursement {

    // private String status;
    // private String submitted;
    // private String resolved;
    // private String desc; //description of the reimbursement request
    // private String receipt;

    @Id
    @Column(name = "reimb_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @CreationTimestamp
    @Column(name = "submitted", nullable = false)
    private LocalDateTime submitTime; // submitted time

    @CreationTimestamp
    @Column(name = "resolved", nullable = false)
    private LocalDateTime resolveTime; // resolved time

    @Column(name = "description", nullable = false)
    private String desc; // description of the reimbursement request

    @Column(name = "receipt", nullable = false)
    private String receipt;

    @Column(name = "reimb_author", nullable = false)
    private String author;

    @Column(name = "reimb_resolver", nullable = false)
    private String resolver;

    @Column(name = "status_ID", nullable = false)
    private String status;

    @Column(name = "type_ID", nullable = false)
    private String type;

    public Reimbursement(int id, double amount, LocalDateTime submitTime, LocalDateTime resolveTime, String desc,
            String receipt, String author, String resolver, String status, String type) {
        this.id = id;
        this.amount = amount;
        this.submitTime = submitTime;
        this.resolveTime = resolveTime;
        this.desc = desc;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setSubTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public LocalDateTime getSubTime() {
        return this.submitTime;
    }

    public void setResTime(LocalDateTime resolveTime) {
        this.resolveTime = resolveTime;
    }

    public LocalDateTime getResTime() {
        return this.resolveTime;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public String getResolver() {
        return this.resolver;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}