package br.com.contact.controller.request;

import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private String email;
    private String phone;
}
