package com.example.mysqlmongodb.controllers.rest;

import com.example.mysqlmongodb.backend.entity.User;
import com.example.mysqlmongodb.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping(
            produces = "application/json"
    )
    public List<User> all(){
        return userRepository.findAll();
    }
}
