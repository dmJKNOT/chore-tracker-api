package com.besties.chore_tracker.conroller;

import com.besties.chore_tracker.entities.Chore;
import com.besties.chore_tracker.entities.Employee;
import com.besties.chore_tracker.entities.User;
import com.besties.chore_tracker.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id) {
        return this.userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        if (user.getChores() != null) {
            for (Chore chore : user.getChores()) {
                chore.setUser(user); // Ensure the bidirectional link is established
            }
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser).getBody();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/chores")
    public ResponseEntity<User> updateUserChores(@PathVariable int id, @RequestBody List<Chore> updatedChores) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Clear existing chores and update with the new list
            user.getChores().clear();
            for (Chore chore : updatedChores) {
                chore.setUser(user); // Set the relationship
                user.addChore(chore);
            }

            // Save the updated user
            User updatedUser = userRepository.save(user);

            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
