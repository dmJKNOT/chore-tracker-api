package com.besties.chore_tracker.repository;

import com.besties.chore_tracker.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
