package com.backend.javabackend.service;

import com.backend.javabackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;

class UserServiceTests {
    @MockBean
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    //TODO: to be implemented
}