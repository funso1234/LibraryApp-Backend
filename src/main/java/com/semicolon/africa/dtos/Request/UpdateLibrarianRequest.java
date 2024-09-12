package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateLibrarianRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
