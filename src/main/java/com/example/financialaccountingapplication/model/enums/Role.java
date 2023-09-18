package com.example.financialaccountingapplication.model.enums;

public enum Role {
    ADMIN("Администратор"),
    MANAGER("Менеджер"),
    USER("Пользователь");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
