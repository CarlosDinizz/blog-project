package com.backend.blog.controller;

import com.backend.blog.dto.user.UserRequestDTO;
import com.backend.blog.dto.user.UserResponseDTO;
import com.backend.blog.model.User;
import com.backend.blog.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO request){
        log.info("POST: /api/v1/user");
        Integer id = service.createUser(request);
        log.info("User created.");
        return ResponseEntity.ok("User created: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Integer id){
        log.info("GET: /api/v1/user/" + id);
        UserResponseDTO responseDTO = service.getUser(id);
        return ResponseEntity.ok(responseDTO);
    }
}
