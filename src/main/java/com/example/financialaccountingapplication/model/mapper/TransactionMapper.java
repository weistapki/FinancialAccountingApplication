package com.example.financialaccountingapplication.model.mapper;

import com.example.financialaccountingapplication.model.entity.Transaction;
import com.example.financialaccountingapplication.model.dto.TransactionDTO;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class TransactionMapper {
    public TransactionDTO toTransactionDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .id(transaction.getId())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .date((Date) transaction.getDate())
                .type(transaction.getType())
                .build();
    }
    public Transaction toTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(new java.util.Date(transactionDTO.getDate().getTime()));
        transaction.setType(transactionDTO.getType());
        return transaction;
    }
}
