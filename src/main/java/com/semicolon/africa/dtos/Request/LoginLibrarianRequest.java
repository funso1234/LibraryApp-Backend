package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginLibrarianRequest {
    private String email;
    private String password;
}
