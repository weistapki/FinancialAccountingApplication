package com.example.financialaccountingapplication.model.entity.dto;

import com.example.financialaccountingapplication.model.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDTO {
    private Long id;
    private OrderStatus orderStatus;

    public StatusDTO(Long id, OrderStatus orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }
}
