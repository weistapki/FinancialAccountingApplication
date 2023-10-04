package com.example.financialaccountingapplication.repository;


import com.example.financialaccountingapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Дополнительные методы могут быть добавлены сюда, если требуется выполнить
    // пользовательские операции для сущности User.
}

