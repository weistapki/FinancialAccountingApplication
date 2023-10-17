package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.User;
import com.example.financialaccountingapplication.model.entity.dto.UserDTO;
import com.example.financialaccountingapplication.model.mapper.UserMapper;
import com.example.financialaccountingapplication.repository.UserRepository;
import com.example.financialaccountingapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserDTO).orElse(null);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        user = userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO updatedUserDTO) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    User updatedUser = userMapper.toUser(updatedUserDTO);
                    updatedUser.setId(existingUser.getId());
                    // Другие поля для обновления

                    updatedUser = userRepository.save(updatedUser);
                    return userMapper.toUserDTO(updatedUser);
                })
                .orElse(null); // Пользователь не найден, обновление не выполнено
    }
}
