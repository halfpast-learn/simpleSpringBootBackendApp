package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Contact;

@Repository
public class InMemoryContactDao implements ContactDao {

    private static List<Contact> contacts = new ArrayList<>();

    @Override
    public int insertContact(UUID id, Contact contact) {
        contacts.add(new Contact(id, contact.getName(), contact.getPhone()));
        return 0;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Optional<Contact> getContactById(UUID id) {
        return contacts.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public int updateContactById(UUID id, Contact contact) {
        return getContactById(id).map(c -> {
            int index = contacts.indexOf(c);
            if (index == -1) {
                return 1;
            }
            contacts.set(index, contact);
            return 0;
        }).orElse(1);
    }

    @Override
    public int deleteContactById(UUID id) {
        Optional<Contact> cOptional = getContactById(id);
        if (cOptional.isEmpty()) {
            return 1;
        }
        contacts.remove(cOptional.get());
        return 0;
    }

}
