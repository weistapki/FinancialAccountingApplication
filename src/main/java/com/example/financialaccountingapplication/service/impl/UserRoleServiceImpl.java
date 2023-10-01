package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.UserRole;
import com.example.financialaccountingapplication.repository.UserRoleRepository;
import com.example.financialaccountingapplication.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getUserRoleById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
    @Override
    public UserRole updateUserRole(Long id, UserRole updatedUserRole) {
        return userRoleRepository.findById(id)
                .map(existingUserRole -> {
                    existingUserRole.setRole(updatedUserRole.getRole());
                    // Другие поля для обновления

                    return userRoleRepository.save(existingUserRole);
                })
                .orElse(null); // Роль пользователя не найдена, обновление не выполнено
    }
}

