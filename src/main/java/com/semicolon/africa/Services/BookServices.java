package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.dtos.Request.AddBookRequest;
import com.semicolon.africa.dtos.Request.RemoveBookRequest;
import com.semicolon.africa.dtos.Request.UpdateBookRequest;
import com.semicolon.africa.dtos.Response.AddBookResponse;
import com.semicolon.africa.dtos.Response.RemoveBookResponse;
import com.semicolon.africa.dtos.Response.UpdateBookResponse;

import java.util.List;

public interface BookServices {
    AddBookResponse addBook(AddBookRequest addBookRequest);
    RemoveBookResponse deleteBook(RemoveBookRequest removeBookRequest);
    UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);
    List<Book> getAllBooks();
    Long getTotalBook();
}


