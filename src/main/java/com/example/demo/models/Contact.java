package com.example.demo.models;

import java.util.UUID;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Contact {
    private UUID id;
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
    }
}
