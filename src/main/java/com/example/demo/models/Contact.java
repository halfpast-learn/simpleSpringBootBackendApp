package com.example.demo.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Contact {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
    }
}
