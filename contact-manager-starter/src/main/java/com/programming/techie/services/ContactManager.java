package com.programming.techie.services;

import com.programming.techie.entities.Contact;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

    Map<String, Contact> contactList = new ConcurrentHashMap<>();

    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        checkIfContactAlreadyExists(contact);
        contactList.put(generateKey(contact), contact);
    }

    public Collection<Contact> getAllContacts() {
        return contactList.values();
    }

    private void checkIfContactAlreadyExists(Contact contact) {
        if (contactList.containsKey(generateKey(contact))) {
            throw new RuntimeException("Contact already exists");
        }
    }

    private String generateKey(Contact contact) {
        return String.format("%s_%s", contact.getFirstName(), contact.getLastName());
    }

    private void validateContact(Contact contact) {
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }
}
