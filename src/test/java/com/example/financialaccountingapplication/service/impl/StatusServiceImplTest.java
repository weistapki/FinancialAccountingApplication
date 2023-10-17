package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.Status;
import com.example.financialaccountingapplication.model.entity.dto.StatusDTO;
import com.example.financialaccountingapplication.model.enums.OrderStatus;
import com.example.financialaccountingapplication.model.mapper.StatusMapper;
import com.example.financialaccountingapplication.repository.StatusRepository;
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

public class StatusServiceImplTest {

    @InjectMocks
    private StatusServiceImpl statusService;

    @Mock
    private StatusRepository statusRepository;

    @Mock
    private StatusMapper statusMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStatuses() {
        // Подготовка заглушек
        when(statusRepository.findAll()).thenReturn(Arrays.asList(new Status(), new Status()));
        when(statusMapper.toStatusDTO(any())).thenReturn(new StatusDTO(1L, OrderStatus.SHIPPED)); // Заменил на SHIPPED

        // Вызов метода
        List<StatusDTO> statusDTOs = statusService.getAllStatuses();

        // Проверки
        assertEquals(2, statusDTOs.size());
        for (StatusDTO statusDTO : statusDTOs) {
            assertNotNull(statusDTO);
            assertEquals(OrderStatus.SHIPPED, statusDTO.getOrderStatus());
        }
    }

    @Test
    public void testGetStatusById() {
        // Подготовка заглушек
        Long statusId = 1L;
        Status status = new Status();
        StatusDTO statusDTO = new StatusDTO(1L, OrderStatus.SHIPPED); // Заменил на SHIPPED
        when(statusRepository.findById(statusId)).thenReturn(Optional.of(status));
        when(statusMapper.toStatusDTO(status)).thenReturn(statusDTO);

        // Вызов метода
        StatusDTO result = statusService.getStatusById(statusId);

        // Проверки
        assertNotNull(result);
        assertEquals(OrderStatus.SHIPPED, result.getOrderStatus());
    }

    @Test
    public void testSaveStatus() {
        // Подготовка заглушек
        StatusDTO statusDTO = new StatusDTO(1L, OrderStatus.SHIPPED); // Заменил на SHIPPED
        Status status = new Status();
        when(statusMapper.toStatus(statusDTO)).thenReturn(status);
        when(statusRepository.save(status)).thenReturn(status);
        when(statusMapper.toStatusDTO(status)).thenReturn(statusDTO);

        // Вызов метода
        StatusDTO result = statusService.saveStatus(statusDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(OrderStatus.SHIPPED, result.getOrderStatus());
    }

    @Test
    public void testDeleteStatus() {
        // Вызов метода
        statusService.deleteStatus(1L);

        // Проверки
        verify(statusRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateStatus() {
        // Подготовка заглушек
        Long statusId = 1L;
        StatusDTO statusDTO = new StatusDTO(1L, OrderStatus.SHIPPED); // Заменил на SHIPPED
        Status existingStatus = new Status();
        Status updatedStatus = new Status();
        when(statusRepository.findById(statusId)).thenReturn(Optional.of(existingStatus));
        when(statusMapper.toStatus(statusDTO)).thenReturn(updatedStatus);
        when(statusRepository.save(updatedStatus)).thenReturn(updatedStatus);
        when(statusMapper.toStatusDTO(updatedStatus)).thenReturn(statusDTO);

        // Вызов метода
        StatusDTO result = statusService.updateStatus(statusId, statusDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(OrderStatus.SHIPPED, result.getOrderStatus());
    }
}


