package br.com.contact.controller.request;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ContactResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
