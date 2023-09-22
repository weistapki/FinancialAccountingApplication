package com.example.financialaccountingapplication.service;

import com.example.financialaccountingapplication.model.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
