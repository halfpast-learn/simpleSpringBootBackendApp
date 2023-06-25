package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Contact;
import com.example.demo.services.ContactService;

@RestController
@RequestMapping(path = "api/contact")
public class ContactController {
    private final ContactService contactService;
    
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/insert")
    public int insertContact(@RequestBody Contact contact) {
        return contactService.insertContact(contact);
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Contact> getContactById(@PathVariable UUID id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/update/{id}")
    public int updateContact(@PathVariable UUID id, @RequestBody Contact contact) {
        return contactService.updateContactById(id, contact);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteContactById(@PathVariable UUID id) {
        return this.deleteContactById(id);
    }
    
}
