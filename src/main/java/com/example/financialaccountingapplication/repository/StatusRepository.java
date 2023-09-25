package com.example.financialaccountingapplication.repository;

import com.example.financialaccountingapplication.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
    // Дополнительные методы могут быть добавлены сюда, если требуется выполнить
    // пользовательские операции для сущности Status.
}
