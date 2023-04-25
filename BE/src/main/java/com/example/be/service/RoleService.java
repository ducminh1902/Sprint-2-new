package com.example.be.service;

import com.example.be.model.Role;
import com.example.be.model.RoleName;
import com.example.be.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return iRoleRepository.findByName(name);
    }
}
