package com.example.financialaccountingapplication.model.entity.dto;

import com.example.financialaccountingapplication.model.enums.OrderStatus;
import com.example.financialaccountingapplication.model.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Builder
@Data
public class TransactionDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Date date;
    private TransactionType type;
}
