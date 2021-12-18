package br.com.contact.controller;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.request.ContactResponse;
import br.com.contact.service.ContactService;
import br.com.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

   @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> get(){
        return this.contactService.getAllContacts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactRequest contact){
        this.contactService.createContact(contact);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@RequestParam Long id){
        this.contactService.removeContact(id);

    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse getContactByName(@RequestParam String name){
        return this.contactService.getContactByName(name);
    }

    @PutMapping
    public void updateContact(@RequestBody ContactRequest contactRequest, @RequestParam Long id){
        this.contactService.updateContact(contactRequest, id);
    }
}
