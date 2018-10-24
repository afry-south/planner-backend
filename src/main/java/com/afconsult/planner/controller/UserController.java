package com.afconsult.planner.controller;

import com.afconsult.planner.repository.User;
import com.afconsult.planner.repository.UserRepository;
import com.afconsult.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @UserController provides endpoints for retrieving user information.
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint for retrieving user information based on name.
     * @param name
     * @return ResponseEntity Object
     */
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUser(@PathVariable String name) {
        return userService.getUserByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}