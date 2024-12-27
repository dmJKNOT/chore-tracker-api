package com.besties.chore_tracker.repository;

import com.besties.chore_tracker.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
