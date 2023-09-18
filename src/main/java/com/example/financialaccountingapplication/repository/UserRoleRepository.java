package com.example.financialaccountingapplication.repository;

import com.example.financialaccountingapplication.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRoleRepository extends JpaRepository<UserRole,Long> {
}
