package com.semicolon.africa.Data.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Librarian {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    @DBRef
    List<Book> bookList = new ArrayList<>();
    private boolean isLoggedIn;

}
