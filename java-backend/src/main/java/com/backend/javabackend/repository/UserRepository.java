package com.backend.javabackend.repository;

import com.backend.javabackend.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
