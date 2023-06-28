package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.repositories.ContactRepository;

@Service("DB")
public class ContactServiceRepository implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public int insertContact(Contact contact) {
        try {
            contactRepository.save(contact);
        } catch (Exception e) {
            System.err.println(e.getStackTrace().toString());
            return 1;
        }
        return 0;
    }

    @Override
    public List<Contact> getContacts() {
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            return null;
        }
    }

    @Override
    public Optional<Contact> getContactById(UUID id) {
        try {
            return contactRepository.findById(id);
        } catch (Exception e) {
            System.err.println(e.getStackTrace().toString());
            return null;
        }
    }

    @Override
    public int updateContactById(UUID id, Contact contact) {
        try {
            Contact contactToUpdate = new Contact(id, contact.getName(), contact.getPhone());
            contactRepository.save(contactToUpdate);
        }
        catch(Exception e) {
            System.err.println(e.getStackTrace().toString());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteContactById(UUID id) {
        try {
            contactRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println(e.getStackTrace().toString());
            return 1;
        }
        return 0;
    }
}
