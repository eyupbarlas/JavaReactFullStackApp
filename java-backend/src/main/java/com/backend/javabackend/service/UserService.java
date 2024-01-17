package com.backend.javabackend.service;

import com.backend.javabackend.data.User;
import com.backend.javabackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createNewUser(User request){
        User user = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .email(request.getEmail()).build();

        userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            // @TODO: Throw custom exception
            log.error("There is no user with this id {}", userId);
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public ResponseEntity<User> updateUser(Long userId, User user) {
        User studentFoundById = userRepository.findById(userId)
                .orElseThrow( ()-> new IllegalStateException("Student not found with this id :: "+userId));

        boolean isPresent = userRepository.findById(user.getId()).isPresent();
        if (isPresent){
            log.error("The provided Id {} is already taken", userId);
            // @TODO: Throw custom exception
        }

        studentFoundById.setName(user.getName());
        studentFoundById.setEmail(user.getEmail());
        studentFoundById.setUsername(user.getUsername());
        return ResponseEntity.ok(studentFoundById);

    }

}
