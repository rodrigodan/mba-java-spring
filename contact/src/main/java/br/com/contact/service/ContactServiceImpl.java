package br.com.contact.service;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.request.ContactResponse;
import br.com.contact.model.Contact;
import br.com.contact.repository.ContactRepository;
import br.com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void createContact(ContactRequest contact) {
        // criar um contact
        this.contactRepository.save(new Contact().convertertToEntity(contact));
    }

    @Override
    public void removeContact(Long id) {
        // remover um contact
        this.contactRepository.deleteById(id);
    }

    @Override
    public ContactResponse getContactByName(String name) {
        // remover um contact by name
        /*List<Contact> contacts = this.contactRepository.findAll();
        Contact c = contacts.stream().filter(contact ->contact.getName().equals(name)).findAny().get();*/
        Contact contact = this.contactRepository.findByName(name);
        ContactResponse contactResponse = contact.convertertToContactResponse(contact);
        return contactResponse;
    }

    @Override
    public ContactResponse getByName(String name) {
        Contact contact = this.contactRepository.findByName(name);
        return contact.convertertToContactResponse(contact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        // listar todos os contacts
        return this.contactRepository.findAll()
                .stream().map(contact->contact.convertertToContactResponse(contact))
                .collect(Collectors.toList());
    }

    @Override
    public void updateContact(ContactRequest contactRequest, Long id) {
        Contact c = this.contactRepository.findById(id).get();
        Contact c2 = new Contact().convertertToEntity(contactRequest);
        c2.setId(c.getId());
        this.contactRepository.save(c2);
    }

}
