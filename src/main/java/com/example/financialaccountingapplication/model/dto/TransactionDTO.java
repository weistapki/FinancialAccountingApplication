package com.example.financialaccountingapplication.model.dto;

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

    public TransactionDTO(Long id, String description, BigDecimal amount, Date date, TransactionType type) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
}
