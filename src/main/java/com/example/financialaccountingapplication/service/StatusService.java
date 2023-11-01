package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.dto.StatusDTO;
import java.util.List;


public interface StatusService {
    List<StatusDTO> getAllStatuses();
    StatusDTO getStatusById(Long id);
    StatusDTO saveStatus(StatusDTO statusDTO);
    void deleteStatus(Long id);
    StatusDTO updateStatus(Long id, StatusDTO statusDTO);
}


