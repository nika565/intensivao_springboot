package com.nathan.agregadorinvestimentos.controller;

import com.nathan.agregadorinvestimentos.dto.CreateUserDto;
import com.nathan.agregadorinvestimentos.dto.UpdateUserDto;
import com.nathan.agregadorinvestimentos.entity.User;
import com.nathan.agregadorinvestimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto dto) {
        UUID userId = userService.createUser(dto);
        return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String userId) {
        var user = userService.getUserById(userId);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") String id, @RequestBody UpdateUserDto dto) {
        userService.updateUserById(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
