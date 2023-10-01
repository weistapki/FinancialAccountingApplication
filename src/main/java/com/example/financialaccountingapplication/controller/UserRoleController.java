package com.example.financialaccountingapplication.controller;

import com.example.financialaccountingapplication.model.entity.UserRole;
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
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        return userRoleService.getUserRoleById(id).orElse(null);
    }

    @PostMapping("/")
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.saveUserRole(userRole);
    }

    @PutMapping("/{id}")
    public UserRole updateUserRole(@PathVariable Long id, @RequestBody UserRole userRole) {
        return userRoleService.updateUserRole(id,userRole);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
    }
}
