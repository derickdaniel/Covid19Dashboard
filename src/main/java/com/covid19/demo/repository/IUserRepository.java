package com.covid19.demo.repository;

import com.covid19.demo.entity.User;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, UUID> {
  
  public Optional<User> findByEmail(String email);
  
}
