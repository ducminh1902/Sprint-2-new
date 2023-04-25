package com.example.be.service;

import com.example.be.model.User;
import com.example.be.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public Optional<User> findByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return iUserRepository.existsByUserName(userName);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return iUserRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
