package com.example.financialaccountingapplication.model.mapper;

import com.example.financialaccountingapplication.model.entity.Status;
import com.example.financialaccountingapplication.model.dto.StatusDTO;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusDTO toStatusDTO(Status status) {
        return StatusDTO.builder()
                .id(status.getId())
                .orderStatus(status.getOrderStatus())
                .build();
    }

    public Status toStatus(StatusDTO statusDTO) {
        Status status = new Status();
        status.setId(statusDTO.getId());
        status.setOrderStatus(statusDTO.getOrderStatus());
        return status;
    }
}
