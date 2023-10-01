package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.User;



import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
