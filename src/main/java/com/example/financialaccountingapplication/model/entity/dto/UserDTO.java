package com.example.financialaccountingapplication.model.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Set<TransactionDTO> transactions; // Можно также создать DTO для Transaction

}
