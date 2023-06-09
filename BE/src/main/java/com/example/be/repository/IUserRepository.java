package com.example.be.repository;

import com.example.be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
