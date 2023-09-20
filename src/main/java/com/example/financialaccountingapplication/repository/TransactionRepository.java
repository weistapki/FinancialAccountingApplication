package com.example.financialaccountingapplication.repository;

import com.example.financialaccountingapplication.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Дополнительные методы могут быть добавлены сюда, если требуется выполнить
    // пользовательские операции для сущности Transaction.
}
