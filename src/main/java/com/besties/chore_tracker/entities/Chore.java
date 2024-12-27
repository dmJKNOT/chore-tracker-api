package com.besties.chore_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "chores")
public class Chore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String choreName;
    private String choreDescription;
    private boolean isCompleted;
    private LocalDate lastCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    private Chore() {}

    public Chore(String choreName, String choreDescription, boolean isCompleted, LocalDate lastCompleted) {
        this.choreName = choreName;
        this.choreDescription = choreDescription;
        this.isCompleted = isCompleted;
        this.lastCompleted = lastCompleted;
    }

    public Integer getId() {
        return id;
    }

    public String getChoreName() {
        return choreName;
    }

    public String getChoreDescription() {
        return choreDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public LocalDate getLastCompleted() {
        return lastCompleted;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

