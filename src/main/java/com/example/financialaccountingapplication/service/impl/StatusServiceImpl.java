package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.Status;
import com.example.financialaccountingapplication.model.entity.dto.StatusDTO;
import com.example.financialaccountingapplication.model.mapper.StatusMapper;
import com.example.financialaccountingapplication.repository.StatusRepository;
import com.example.financialaccountingapplication.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    @Override
    public List<StatusDTO> getAllStatuses() {
        List<Status> statuses = statusRepository.findAll();
        return statuses.stream()
                .map(statusMapper::toStatusDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StatusDTO getStatusById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.map(statusMapper::toStatusDTO).orElse(null);
    }

    @Override
    public StatusDTO saveStatus(StatusDTO statusDTO) {
        Status status = statusMapper.toStatus(statusDTO);
        status = statusRepository.save(status);
        return statusMapper.toStatusDTO(status);
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
    @Override
    public StatusDTO updateStatus(Long id, StatusDTO statusDTO) {
        Optional<Status> existingStatus = statusRepository.findById(id);

        return existingStatus.map(status -> {
            // Обновляем существующий статус данными из DTO
            Status updatedStatus = statusMapper.toStatus(statusDTO);
            updatedStatus.setId(id);

            // Сохраняем обновленный статус и возвращаем его DTO
            return statusMapper.toStatusDTO(statusRepository.save(updatedStatus));
        }).orElse(null); // Или бросайте исключение, если статус с указанным id не найден
    }
}

