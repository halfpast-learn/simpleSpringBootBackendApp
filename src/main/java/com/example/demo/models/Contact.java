package com.example.demo.models;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private UUID id;
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Contact))
            return false;
        Contact other = (Contact) o;
        return other.getId().equals(this.id);
    }
}
