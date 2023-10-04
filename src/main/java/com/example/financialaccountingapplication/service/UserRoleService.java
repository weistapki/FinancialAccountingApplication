package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> getAllUserRoles();
    Optional<UserRole> getUserRoleById(Long id);
    UserRole saveUserRole(UserRole userRole);
    void deleteUserRole(Long id);
    UserRole updateUserRole(Long id, UserRole updatedUserRole);
}

