package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Repositories.LibrarianRepository;
import com.semicolon.africa.dtos.Request.RegisterLibrarianRequest;
import com.semicolon.africa.dtos.Response.RegisterLibrarianResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LibrarianServicesTest {
    @Autowired
    private LibrarianServices librarianServices;
    @Autowired
    private LibrarianRepository librarianRepository;
    @Test
    void testThatLibrarianCanBeRegistered(){
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("John");
        registerLibrarianRequest.setLastName("Doe");
        registerLibrarianRequest.setEmail("sam@gmail.com.com");
        registerLibrarianRequest.setPassword("password");
        registerLibrarianRequest.setPhoneNumber("1234");
        librarianServices.registerLibrarian(registerLibrarianRequest);
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");

    }
}
