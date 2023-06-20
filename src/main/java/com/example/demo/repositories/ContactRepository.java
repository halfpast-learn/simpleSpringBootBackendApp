package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Contact;

@Repository
public interface ContactRepository {
    int insertContact(UUID id, Contact contact);

    default int insertContact(Contact contact) {
        UUID id = UUID.randomUUID();
        return this.insertContact(id, contact);
    }

    List<Contact> getContacts();

    Optional<Contact> getContactById(UUID id); 

    int updateContactById(UUID id, Contact contact);

    int deleteContactById(UUID id);
}