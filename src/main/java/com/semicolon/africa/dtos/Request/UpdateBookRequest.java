package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBookRequest {
    private String title;
    private String author;
    private String isbn;
    private String edition;
    private String dateOfPublication;
    private String newTitle;
    private String newAuthor;
    private String newIsbn;
    private String newEdition;
    private String newDateOfPublication;
}
