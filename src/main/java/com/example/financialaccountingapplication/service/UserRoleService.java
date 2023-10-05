package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.dto.UserRoleDTO;

import java.util.List;


public interface UserRoleService {
    List<UserRoleDTO> getAllUserRoles();
    UserRoleDTO getUserRoleById(Long id);
    UserRoleDTO saveUserRole(UserRoleDTO userRoleDTO);
    UserRoleDTO updateUserRole(Long id, UserRoleDTO userRoleDTO);
    void deleteUserRole(Long id);
}

