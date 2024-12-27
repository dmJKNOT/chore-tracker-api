package com.besties.chore_tracker.repository;

import com.besties.chore_tracker.entities.Chore;
import org.springframework.data.repository.CrudRepository;

public interface ChoreRepository extends CrudRepository<Chore, Integer> {
}
