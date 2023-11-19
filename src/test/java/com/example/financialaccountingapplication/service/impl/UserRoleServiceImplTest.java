package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.UserRole;
import com.example.financialaccountingapplication.model.dto.UserRoleDTO;
import com.example.financialaccountingapplication.model.enums.Role;
import com.example.financialaccountingapplication.repository.UserRoleRepository;
import com.example.financialaccountingapplication.model.mapper.UserRoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class UserRoleServiceImplTest {

    @InjectMocks
    private UserRoleServiceImpl userRoleService;

    @Mock
    private UserRoleRepository userRoleRepository;

    @Mock
    private UserRoleMapper userRoleMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUserRoles() {
        // Подготовка заглушек
        when(userRoleRepository.findAll()).thenReturn(Arrays.asList(new UserRole(), new UserRole()));
        when(userRoleMapper.toUserRoleDTO(any())).thenReturn(new UserRoleDTO(1L, Role.USER));

        // Вызов метода
        List<UserRoleDTO> userRoleDTOs = userRoleService.getAllUserRoles();

        // Проверки
        assertEquals(2, userRoleDTOs.size());
        for (UserRoleDTO userRoleDTO : userRoleDTOs) {
            assertNotNull(userRoleDTO);
            assertEquals(Role.USER, userRoleDTO.getRole());
        }
    }

    @Test
    public void testGetUserRoleById() {
        // Подготовка заглушек
        Long userRoleId = 1L;
        UserRole userRole = new UserRole();
        UserRoleDTO userRoleDTO = new UserRoleDTO(1L, Role.USER);
        when(userRoleRepository.findById(userRoleId)).thenReturn(Optional.of(userRole));
        when(userRoleMapper.toUserRoleDTO(userRole)).thenReturn(userRoleDTO);

        // Вызов метода
        UserRoleDTO result = userRoleService.getUserRoleById(userRoleId);

        // Проверки
        assertNotNull(result);
        assertEquals(Role.USER, result.getRole());
    }

    @Test
    public void testSaveUserRole() {
        // Подготовка заглушек
        UserRoleDTO userRoleDTO = new UserRoleDTO(1L, Role.USER);
        UserRole userRole = new UserRole();
        when(userRoleMapper.toUserRole(userRoleDTO)).thenReturn(userRole);
        when(userRoleRepository.save(userRole)).thenReturn(userRole);
        when(userRoleMapper.toUserRoleDTO(userRole)).thenReturn(userRoleDTO);

        // Вызов метода
        UserRoleDTO result = userRoleService.saveUserRole(userRoleDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(Role.USER, result.getRole());
    }

    @Test
    public void testDeleteUserRole() {
        // Вызов метода
        userRoleService.deleteUserRole(1L);

        // Проверки
        verify(userRoleRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateUserRole() {
        // Подготовка заглушек
        Long userRoleId = 1L;
        UserRoleDTO userRoleDTO = new UserRoleDTO(1L, Role.USER);
        UserRole existingUserRole = new UserRole();
        UserRole updatedUserRole = new UserRole();
        when(userRoleRepository.findById(userRoleId)).thenReturn(Optional.of(existingUserRole));
        when(userRoleMapper.toUserRole(userRoleDTO)).thenReturn(updatedUserRole);
        when(userRoleRepository.save(updatedUserRole)).thenReturn(updatedUserRole);
        when(userRoleMapper.toUserRoleDTO(updatedUserRole)).thenReturn(userRoleDTO);

        // Вызов метода
        UserRoleDTO result = userRoleService.updateUserRole(userRoleId, userRoleDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(Role.USER, result.getRole());
    }
}
