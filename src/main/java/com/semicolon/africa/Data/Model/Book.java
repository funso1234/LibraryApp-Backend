package com.semicolon.africa.Data.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {
    private String title;
    private String author;
    private String edition;
    private String dateOfPublication;
    private String isbn;
    List<Book> bookList = new ArrayList<>();
}
