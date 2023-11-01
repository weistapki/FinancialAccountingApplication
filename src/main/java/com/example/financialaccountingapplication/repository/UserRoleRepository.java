package com.example.financialaccountingapplication.repository;

import com.example.financialaccountingapplication.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRoleRepository extends JpaRepository<UserRole,Long> {
    // Дополнительные методы могут быть добавлены сюда, если требуется выполнить
    // пользовательские операции для сущности UserRole.
}
