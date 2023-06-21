package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;

@Service
public class ContactService {
    public List<Contact> getContacts() {
        return List.of(
            new Contact("John", "+1234567890"), 
            new Contact("Ben", "+0987654321")
        );
    }

    public Optional<Contact> getContactById(UUID id) {
        return contactRepository.getContactById(id);
    }
}
