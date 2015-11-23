package com.liaolushen.controller;

import com.liaolushen.domain.Contact;
import com.liaolushen.rest.StringResponse;
import com.liaolushen.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
@RestController
@RequestMapping(produces = "application/json")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public StringResponse addContact(@RequestBody @Valid final Contact contact) {
        return contactService.save(contact);
    }

    @RequestMapping(value = "/get-all-contacts", method = RequestMethod.GET)
    public StringResponse getAllContact() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "/get-contact-by-name", method = RequestMethod.GET, params = {"name"})
    public StringResponse getContactByName(@RequestParam("name") String name) {
        return contactService.getContactByName(name);
    }

    @RequestMapping(value = "/get-contact-by-name", method = RequestMethod.GET, params = {"phoneNumber"})
    public StringResponse getContactByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return contactService.getContactByPhoneNumber(phoneNumber);
    }
}
