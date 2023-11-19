package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
    TransactionDTO getTransactionById(Long id);
    TransactionDTO saveTransaction(TransactionDTO transactionDTO);
    void deleteTransaction(Long id);
    TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO);
}
