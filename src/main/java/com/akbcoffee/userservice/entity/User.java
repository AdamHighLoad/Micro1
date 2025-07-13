package com.akbcoffee.userservice.entity;

import jakarta.persistence.*; // JPA — связь Java <-> таблица
import java.time.LocalDateTime;

@Entity // Говорим Hibernate, что этот класс = таблица в БД
@Table(name = "users") // Явно указываем имя таблицы
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент, как SERIAL в Postgres
    private Long id;

    @Column(nullable = false, unique = true) // не может быть null, и email уникален
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Обязательно нужны конструкторы
    public User() {
// Hibernate требует пустой конструктор
    }

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.createdAt = LocalDateTime.now();
    }

    // Геттеры и сеттеры — нужны для доступа к полям
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}