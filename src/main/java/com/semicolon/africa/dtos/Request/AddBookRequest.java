package com.semicolon.africa.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddBookRequest {
    private String title;
    private String author;
    private String edition;
    private String dateOfPublication;
    private String isbn;

}
