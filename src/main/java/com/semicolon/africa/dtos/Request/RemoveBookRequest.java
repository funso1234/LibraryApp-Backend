package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemoveBookRequest {
    private String title;
    private String author;
    private String isbn;

}
