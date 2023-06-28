package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.models.Contact;

public interface ContactService {
    public int insertContact(Contact contact);

    public List<Contact> getContacts();

    public Optional<Contact> getContactById(UUID id);

    public int updateContactById(UUID id, Contact contact);

    public int deleteContactById(UUID id);
}