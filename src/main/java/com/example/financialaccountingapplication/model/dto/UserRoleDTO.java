package com.example.financialaccountingapplication.model.dto;

import com.example.financialaccountingapplication.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleDTO {
    private Long id;
    private Role role;

    public UserRoleDTO(Long id, Role role) {
        this.id = id;
        this.role = role;
    }
}
