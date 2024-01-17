package com.backend.javabackend.rest;

import com.backend.javabackend.data.User;
import com.backend.javabackend.data.UserResponse;
import com.backend.javabackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

import static com.backend.javabackend.constants.FullStackAppConstants.API_V_1_USER;

@RestController
@RequestMapping(value = API_V_1_USER)
@RequiredArgsConstructor
public class UserRest {

    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<UserResponse> getUsers() {
        return ResponseEntity.ok(
                UserResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("users" , userService.getAllUsers()))
                        .message("Users retrieved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(
                UserResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("user" , userService.createNewUser(user)))
                        .message("User created successfully")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
            .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                UserResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("user" , userService.getUser(id)))
                        .message("User retrieved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                UserResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("user" , userService.deleteUserById(id)))
                        .message("Server deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    //TODO: Add update user endpoint
}
