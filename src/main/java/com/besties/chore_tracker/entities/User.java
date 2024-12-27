package com.besties.chore_tracker.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Chore> chores;

    public void addChore(Chore chore) {
        chores.add(chore);
        chore.setUser(this); // Sync the reverse relationship
    }

    public void removeChore(Chore chore) {
        chores.remove(chore);
        chore.setUser(null); // Break the reverse relationship
    }

    public List<Chore> getChores() {
        return chores;
    }

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private User() {}

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }



}