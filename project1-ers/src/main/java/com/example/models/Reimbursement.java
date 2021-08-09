package com.example.models;

import java.time.LocalDateTime;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursement {

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

    @Column(name = "receipt", nullable = true)
    private String receipt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reimb_author", nullable = false)
    private User employee_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reimb_resolver", nullable = false)
    private User manager_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private RStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private RType type;

    public Reimbursement() {
        super();
    }

    public Reimbursement(double amount, String desc, RStatus status, RType type) {
        super();
        this.amount = amount;
        this.desc = desc;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(double amount, String desc, RStatus submitted, RType type, User author, User resolver) {
        super();
        this.amount = amount;
        this.desc = desc;
        this.status = submitted;
        this.type = type;
        this.employee_id = author;
        this.manager_id = resolver;
    }

    public Reimbursement(int id, double amount, LocalDateTime submitTime, LocalDateTime resolveTime, String desc,
            String receipt, User author, User resolver, RStatus status, RType type) {
        super();
        this.id = id;
        this.amount = amount;
        this.submitTime = submitTime;
        this.resolveTime = resolveTime;
        this.desc = desc;
        this.receipt = receipt;
        this.employee_id = author;
        this.manager_id = resolver;
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

    public void setAuthor(User employee) {
        this.employee_id = employee;
    }

    public User getAuthor() {
        return this.employee_id;
    }

    public void setResolver(User resolver) {
        this.manager_id = resolver;
    }

    public User getResolver() {
        return this.manager_id;
    }

    public void setType(RType type) {
        this.type = type;
    }

    public RType getType() {
        return this.type;
    }

    public void setStatus(RStatus status) {
        this.status = status;
    }

    public RStatus getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Reimbursement [amount=" + amount + ", desc=" + desc + ", employee_id=" + employee_id.getUsername()
                + ", id=" + id + ", manager_id=" + manager_id.getUsername() + ", receipt=" + receipt + ", resolveTime="
                + resolveTime + ", status=" + status + ", submitTime=" + submitTime + ", type=" + type + "]";
    }

}

// private String submitted;
// private String resolved;
// private String desc; //description of the reimbursement request
// private String receipt;