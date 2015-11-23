package com.liaolushen.service;

import com.liaolushen.domain.Contact;
import com.liaolushen.repository.ContactRepository;
import com.liaolushen.rest.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
@Service
@Validated
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;

    @Autowired
    public ContactServiceImpl(final ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public StringResponse save(Contact contact) {
        return new StringResponse("success", repository.save(contact));
    }

    @Override
    public StringResponse getContactByName(String name) {
        List<Contact> allContacts = (List<Contact>) repository.findAll();
        for (Contact contact: allContacts) {
            if (contact.getName().equals(name)) {
                return new StringResponse("success", contact);
            }
        }
        return new StringResponse("failure", null);
    }

    @Override
    public StringResponse getContactByPhoneNumber(String phoneNumber) {
        List<Contact> allContacts = (List<Contact>) repository.findAll();
        for (Contact contact: allContacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return new StringResponse("success", contact);
            }
        }
        return new StringResponse("failure", null);
    }

    @Override
    public StringResponse getAllContacts() {
        return new StringResponse("success", repository.findAll());
    }
}
