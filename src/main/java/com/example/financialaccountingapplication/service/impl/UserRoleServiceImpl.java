package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.UserRole;
import com.example.financialaccountingapplication.model.entity.dto.UserRoleDTO;
import com.example.financialaccountingapplication.model.mapper.UserRoleMapper;
import com.example.financialaccountingapplication.repository.UserRoleRepository;
import com.example.financialaccountingapplication.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRoleMapper::toUserRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDTO getUserRoleById(Long id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        return userRole.map(userRoleMapper::toUserRoleDTO).orElse(null);
    }

    @Override
    public UserRoleDTO saveUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleMapper.toUserRole(userRoleDTO);
        userRole = userRoleRepository.save(userRole);
        return userRoleMapper.toUserRoleDTO(userRole);
    }

    @Override
    public UserRoleDTO updateUserRole(Long id, UserRoleDTO userRoleDTO) {
        Optional<UserRole> existingUserRole = userRoleRepository.findById(id);
        if (existingUserRole.isPresent()) {
            UserRole userRole = userRoleMapper.toUserRole(userRoleDTO);
            userRole.setId(id);
            userRole = userRoleRepository.save(userRole);
            return userRoleMapper.toUserRoleDTO(userRole);
        }
        return null;
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}


