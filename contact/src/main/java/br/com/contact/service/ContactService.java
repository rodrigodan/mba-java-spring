package br.com.contact.service;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.request.ContactResponse;
import br.com.contact.model.Contact;

import java.util.List;

public interface ContactService {
    public void createContact(ContactRequest contact);
    public void removeContact(Long id);
    public ContactResponse getContactByName(String name);
    public ContactResponse getByName(String name);
    public List<ContactResponse> getAllContacts();
    public void updateContact(ContactRequest contact, Long id);
}
