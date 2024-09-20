package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Repositories.BookRepository;
import com.semicolon.africa.Data.Repositories.LibrarianRepository;
import com.semicolon.africa.dtos.Request.*;
import com.semicolon.africa.dtos.Response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LibrarianServicesTest {

    @BeforeEach
    void setUp() {
        librarianRepository.deleteAll();
        bookRepository.deleteAll();
    }

    @Autowired
    private BookServices bookServices;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibrarianServices librarianServices;
    @Autowired
    private LibrarianRepository librarianRepository;

    @Test
    void testThatLibrarianCanBeRegistered() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("John");
        registerLibrarianRequest.setLastName("Doe");
        registerLibrarianRequest.setEmail("sam@gmail.com");
        registerLibrarianRequest.setPassword("password");
        registerLibrarianRequest.setPhoneNumber("1234");
        librarianServices.registerLibrarian(registerLibrarianRequest);
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");

    }

    @Test
    void testThatLibrarianCanLogin() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("John");
        registerLibrarianRequest.setLastName("Doe");
        registerLibrarianRequest.setEmail("sam@gmail.com");
        registerLibrarianRequest.setPassword("111");
        registerLibrarianRequest.setPhoneNumber("1234");
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");
        LoginLibrarianRequest loginLibrarianRequest = new LoginLibrarianRequest();
        loginLibrarianRequest.setEmail("sam@gmail.com");
        loginLibrarianRequest.setPassword("111");
        librarianServices.loginLibrarian(loginLibrarianRequest);
        LoginLibrarianResponse loginLibrarianResponse = librarianServices.loginLibrarian(loginLibrarianRequest);
        assertThat(loginLibrarianRequest).isNotNull();
        assertThat(loginLibrarianResponse.getMessage()).isEqualTo("Successfully logged in");
    }

    @Test
    void testThatLibrarianCanLogout() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("John");
        registerLibrarianRequest.setLastName("Doe");
        registerLibrarianRequest.setEmail("sam@gmail.com");
        registerLibrarianRequest.setPassword("111");
        registerLibrarianRequest.setPhoneNumber("1234");
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");
        LoginLibrarianRequest loginLibrarianRequest = new LoginLibrarianRequest();
        loginLibrarianRequest.setEmail("sam@gmail.com");
        loginLibrarianRequest.setPassword("111");
        librarianServices.loginLibrarian(loginLibrarianRequest);
        LoginLibrarianResponse loginLibrarianResponse = librarianServices.loginLibrarian(loginLibrarianRequest);
        assertThat(loginLibrarianRequest).isNotNull();
        assertThat(loginLibrarianResponse.getMessage()).isEqualTo("Successfully logged in");
        LogoutLibrarianRequest logoutLibrarianRequest = new LogoutLibrarianRequest();
        logoutLibrarianRequest.setEmail("sam@gmail.com");
        logoutLibrarianRequest.setPassword("111");
        LogoutLibrarianResponse logoutLibrarianResponse = librarianServices.logoutLibrabrian(logoutLibrarianRequest);
        assertThat(logoutLibrarianRequest).isNotNull();
        assertThat(logoutLibrarianResponse.getMessage()).isEqualTo("Successfully logged out");

    }

    @Test
    void testThatLibrarianCanBeDeleted() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("John");
        registerLibrarianRequest.setLastName("Doe");
        registerLibrarianRequest.setEmail("sam@gmail.com");
        registerLibrarianRequest.setPassword("111");
        registerLibrarianRequest.setPhoneNumber("1234");
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");
        LoginLibrarianRequest loginLibrarianRequest = new LoginLibrarianRequest();
        loginLibrarianRequest.setEmail("sam@gmail.com");
        loginLibrarianRequest.setPassword("111");
        librarianServices.loginLibrarian(loginLibrarianRequest);
        LoginLibrarianResponse loginLibrarianResponse = librarianServices.loginLibrarian(loginLibrarianRequest);
        assertThat(loginLibrarianRequest).isNotNull();
        assertThat(loginLibrarianResponse.getMessage()).isEqualTo("Successfully logged in");
        DeleteLibrarianRequest deleteLibrarianRequest = new DeleteLibrarianRequest();
        deleteLibrarianRequest.setEmail("sam@gmail.com");
        DeleteLibrarianResponse deleteLibrarianResponse = librarianServices.deleteLibrarian(deleteLibrarianRequest);
        assertThat(deleteLibrarianRequest).isNotNull();
        assertThat(deleteLibrarianResponse.getMessage()).isEqualTo("Successfully deleted");
    }

    @Test
    void testThatLibrarianCanBeUpdated() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("kiki");
        registerLibrarianRequest.setLastName("killer");
        registerLibrarianRequest.setEmail("kiki@gmail.com");
        registerLibrarianRequest.setPassword("111");
        registerLibrarianRequest.setPhoneNumber("1234");
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");
        LoginLibrarianRequest loginLibrarianRequest = new LoginLibrarianRequest();
        loginLibrarianRequest.setEmail("kiki@gmail.com");
        loginLibrarianRequest.setPassword("111");
        librarianServices.loginLibrarian(loginLibrarianRequest);
        LoginLibrarianResponse loginLibrarianResponse = librarianServices.loginLibrarian(loginLibrarianRequest);
        assertThat(loginLibrarianRequest).isNotNull();
        assertThat(loginLibrarianResponse.getMessage()).isEqualTo("Successfully logged in");
        UpdateLibrarianRequest updateLibrarianRequest = new UpdateLibrarianRequest();
        updateLibrarianRequest.setNewFirstName("kiki");
        updateLibrarianRequest.setNewLastName("bello");
        //updateLibrarianRequest.setNewEmail("kiki@gmail.com");
        updateLibrarianRequest.setNewPhoneNumber("1234");
        UpdateLibrarianResponse updateLibrarianResponse = librarianServices.updateLibrarian(updateLibrarianRequest);
        assertThat(updateLibrarianRequest).isNotNull();
        assertThat(updateLibrarianResponse.getMessage()).isEqualTo("Successfully updated");


    }

    @Test
    void testThatBookCanBeAddedToALibrarian() {
        RegisterLibrarianRequest registerLibrarianRequest = new RegisterLibrarianRequest();
        registerLibrarianRequest.setFirstName("Bello");
        registerLibrarianRequest.setLastName("killer");
        registerLibrarianRequest.setEmail("Bello@gmail.com");
        registerLibrarianRequest.setPassword("11111111111");
        registerLibrarianRequest.setPhoneNumber("12345111111");
        RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
        assertThat(registerLibrarianRequest).isNotNull();
        assertThat(registerLibrarianResponse.getMessage()).contains("Successfully registered");
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("love");
        addBookRequest.setAuthor("John");
        addBookRequest.setDateOfPublication("04-01-2009");
        addBookRequest.setIsbn("333");
        addBookRequest.setEdition("2001");
        librarianServices.addLibrarianBook(addBookRequest);
        AddBookResponse addBookResponse = bookServices.addBook(addBookRequest);
        assertThat(addBookResponse).isNotNull();
        assertThat(addBookResponse.getMessage()).isEqualTo("Successfully added");


    }
}