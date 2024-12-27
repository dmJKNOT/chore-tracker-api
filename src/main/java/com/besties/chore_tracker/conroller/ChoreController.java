package com.besties.chore_tracker.conroller;

import com.besties.chore_tracker.entities.Chore;
import com.besties.chore_tracker.repository.ChoreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChoreController {

    private final ChoreRepository choreRepository;

    public ChoreController(ChoreRepository choreRepository) {
        this.choreRepository = choreRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/chores")
    public Iterable<Chore> findAllEmployees() {
        return this.choreRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/chores")
    public Chore addOneEmployee(@RequestBody Chore chore) {
        return this.choreRepository.save(chore);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/chores")
    public void deleteOneEmployee(@RequestBody Chore chore) {
        this.choreRepository.delete(chore);
    }
}