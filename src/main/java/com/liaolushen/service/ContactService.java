package com.liaolushen.service;

import com.liaolushen.domain.Contact;
import com.liaolushen.rest.StringResponse;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
public interface ContactService {
    StringResponse save(Contact contact);
    StringResponse getContactByName(String name);
    StringResponse getContactByPhoneNumber(String phoneNumber);
    StringResponse getAllContacts();
}
