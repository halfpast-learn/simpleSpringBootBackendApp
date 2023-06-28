package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.dao.ContactDao;

@Service("DAO")
public class ContactServiceDao implements ContactService {
    private final ContactDao contactDao;

    public ContactServiceDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public int insertContact(Contact contact) {
        return contactDao.insertContact(contact.getId(), contact);
    }

    public List<Contact> getContacts() {
        return contactDao.getContacts();
    }

    public Optional<Contact> getContactById(UUID id) {
        return contactDao.getContactById(id);
    }

    public int updateContactById(UUID id, Contact contact) {
        return contactDao.updateContactById(id, contact);
    }

    public int deleteContactById(UUID id) {
        return contactDao.deleteContactById(id);
    }
}
