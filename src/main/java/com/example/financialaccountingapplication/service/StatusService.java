package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    List<Status> getAllStatuses();
    Optional<Status> getStatusById(Long id);
    Status saveStatus(Status status);
    void deleteStatus(Long id);
}

