package com.backend.javabackend.service;

import com.backend.javabackend.data.User;
import com.backend.javabackend.exception.UserNotFoundException;
import com.backend.javabackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID: "+ userId));
    }

    public User createNewUser(User request){
        User user = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .email(request.getEmail()).build();

        return userRepository.save(user);
    }

    public Boolean deleteUserById(Long userId){
        userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID: "+ userId));
        userRepository.deleteById(userId);
        return Boolean.TRUE;
    }

    public Boolean deleteUserById22(Long userId){
        userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID: "+ userId));
        userRepository.deleteById(userId);
        return Boolean.TRUE;
    }

    public Boolean deleteUserById222(Long userId){
        userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID: "+ userId));
        userRepository.deleteById(userId);
        return Boolean.TRUE;
    }


    @Transactional
    public ResponseEntity<User> updateUser(Long userId, User user) {
        User studentFoundById = userRepository.findById(userId)
                .orElseThrow( ()-> new IllegalStateException("User not found with this id :: "+userId));

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
