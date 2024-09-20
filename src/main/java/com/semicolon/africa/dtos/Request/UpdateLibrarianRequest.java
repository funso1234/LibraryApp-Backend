package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateLibrarianRequest {
    private String newFirstName;
    private String newLastName;
    private String userEmail;
    private String newPhoneNumber;
}
