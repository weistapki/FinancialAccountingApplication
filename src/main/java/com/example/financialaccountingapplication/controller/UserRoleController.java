package com.example.financialaccountingapplication.controller;


import com.example.financialaccountingapplication.model.entity.dto.UserRoleDTO;
import com.example.financialaccountingapplication.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/")
    public List<UserRoleDTO> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public UserRoleDTO getUserRoleById(@PathVariable Long id) {
        return userRoleService.getUserRoleById(id);
    }

    @PostMapping("/")
    public UserRoleDTO createUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.saveUserRole(userRoleDTO);
    }

    @PutMapping("/{id}")
    public UserRoleDTO updateUserRole(@PathVariable Long id, @RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.updateUserRole(id, userRoleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
    }
}

