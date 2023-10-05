package com.example.financialaccountingapplication.model.mapper;

import com.example.financialaccountingapplication.model.entity.UserRole;
import com.example.financialaccountingapplication.model.entity.dto.UserRoleDTO;

public class UserRoleMapper {

    public UserRoleDTO toUserRoleDTO(UserRole userRole) {
        return UserRoleDTO.builder()
                .id(userRole.getId())
                .role(userRole.getRole())
                .build();
    }

    public UserRole toUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        userRole.setId(userRoleDTO.getId());
        userRole.setRole(userRoleDTO.getRole());
        return userRole;
    }
}

