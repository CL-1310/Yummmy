package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.Contact;
import com.yummmy.webapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ContactService {

    @Autowired
    private ContactRepository repository;

    //    AJOUTER UN CONTACT

    public Contact saveContact(Contact contact){
        return repository.save(contact);
    }

}
