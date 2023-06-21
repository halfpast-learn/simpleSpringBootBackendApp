package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Contact;
import com.example.demo.services.ContactService;

@RestController
@RequestMapping(path = "api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
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
}
