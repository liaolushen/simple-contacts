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
@RequestMapping(produces = "application/json; charset=utf-8")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody StringResponse addContact(@RequestBody @Valid final Contact contact) {
        return contactService.save(contact);
    }

    @RequestMapping(value = "/get-all-contacts", method = RequestMethod.GET)
    public @ResponseBody StringResponse getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "/get-contact-by-name", method = RequestMethod.GET, params = {"name"})
    public @ResponseBody StringResponse getContactByName(@RequestParam(value="name") String name) {
        return contactService.getContactByName(name);
    }

    @RequestMapping(value = "/get-contact-by-phone-number", method = RequestMethod.GET, params = {"phoneNumber"})
    public @ResponseBody StringResponse getContactByPhoneNumber(@RequestParam(value="phoneNumber") String phoneNumber) {
        return contactService.getContactByPhoneNumber(phoneNumber);
    }
}
