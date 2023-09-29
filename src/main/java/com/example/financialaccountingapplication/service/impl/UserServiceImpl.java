package com.example.financialaccountingapplication.service.impl;


import com.example.financialaccountingapplication.repository.UserRepository;
import com.example.financialaccountingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    // Используем сгенерированные геттеры и сеттеры для обновления полей
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    existingUser.setEmail(updatedUser.getEmail());

                    // Другие поля для обновления
                    // ...

                    // Сохраняем обновленного пользователя и возвращаем его
                    return userRepository.save(existingUser);
                })
                .orElse(null); // Если пользователь не найден, возвращаем null
    }

}

