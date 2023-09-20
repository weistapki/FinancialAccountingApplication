package com.example.financialaccountingapplication.model.entity.dto;

import com.example.financialaccountingapplication.model.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDTO {
    private Long id;
    private OrderStatus orderStatus;
}
