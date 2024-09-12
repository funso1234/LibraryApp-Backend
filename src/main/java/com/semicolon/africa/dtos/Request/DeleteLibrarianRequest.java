package com.semicolon.africa.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteLibrarianRequest {
    private String libraryId;
    private String email;
}
