package com.yummmy.webapp.controller;


import com.yummmy.webapp.entity.Contact;
import com.yummmy.webapp.service.ContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ContactController {


    private ContactService service;

    //    AJOUTER UN CONTACT

    @PostMapping("/addContact")
    public Contact addContact(@RequestBody Contact contact){
        return service.saveContact(contact);
    }

}
