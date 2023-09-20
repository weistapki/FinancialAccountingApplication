package com.example.financialaccountingapplication.model.entity.dto;

import com.example.financialaccountingapplication.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleDTO {
    private Long id;
    private Role role;
}
