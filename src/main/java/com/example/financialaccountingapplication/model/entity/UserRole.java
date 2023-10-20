package com.example.financialaccountingapplication.model.entity;

import com.example.financialaccountingapplication.model.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "userRole")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Конструкторы, геттеры, сеттеры и другие методы
    // ...
}
