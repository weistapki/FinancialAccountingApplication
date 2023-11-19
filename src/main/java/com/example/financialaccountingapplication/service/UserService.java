package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO updateUser(Long id, UserDTO updatedUserDTO);
}
