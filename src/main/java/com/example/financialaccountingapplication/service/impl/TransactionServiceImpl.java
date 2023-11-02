package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.Transaction;
import com.example.financialaccountingapplication.model.dto.TransactionDTO;
import com.example.financialaccountingapplication.model.mapper.TransactionMapper;
import com.example.financialaccountingapplication.repository.TransactionRepository;
import com.example.financialaccountingapplication.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transactionMapper::toTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.map(transactionMapper::toTransactionDTO).orElse(null);
    }

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toTransaction(transactionDTO);
        transaction = transactionRepository.save(transaction);
        return transactionMapper.toTransactionDTO(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);

        return existingTransaction.map(transaction -> {
            // Обновляем существующую транзакцию данными из DTO
            Transaction updatedTransaction = transactionMapper.toTransaction(transactionDTO);
            updatedTransaction.setId(id);

            // Сохраняем обновленную транзакцию и возвращаем ее DTO
            return transactionMapper.toTransactionDTO(transactionRepository.save(updatedTransaction));
        }).orElse(null); // Или бросайте исключение, если транзакция с указанным id не найдена
    }
}
