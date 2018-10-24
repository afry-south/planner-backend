package com.afconsult.planner.service;

import com.afconsult.planner.repository.User;
import com.afconsult.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @UserSerivce service class for User.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByName(String name) {
        return Optional.ofNullable(userRepository.findUserByName(name));
    }
}
