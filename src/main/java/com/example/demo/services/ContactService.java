package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.repositories.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(@Qualifier("InMemory") ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    public Optional<Contact> getContactById(UUID id) {
        return contactRepository.getContactById(id);
    }
}
