package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID>  {
    
}