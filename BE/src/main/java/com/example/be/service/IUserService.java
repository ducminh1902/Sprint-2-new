package com.example.be.service;

import com.example.be.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findById(Integer id);
    List<User> findAll();
    void save(User user);
}
