package br.com.contact.model;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.request.ContactResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Contact convertertToEntity(ContactRequest contactRequest){
        return Contact.builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .phone(contactRequest.getPhone())
                .build();
    }

    public ContactResponse convertertToContactResponse(Contact contact){
        return ContactResponse.builder()
                .id(contact.getId())
                .name(contact.getName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }
}
