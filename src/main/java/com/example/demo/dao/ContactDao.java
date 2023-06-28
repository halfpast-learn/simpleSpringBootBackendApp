package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.models.Contact;

public interface ContactDao {
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
