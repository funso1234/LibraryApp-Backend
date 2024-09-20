package com.semicolon.africa.Controller;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Services.BookServices;
import com.semicolon.africa.dtos.Request.AddBookRequest;
import com.semicolon.africa.dtos.Request.RemoveBookRequest;
import com.semicolon.africa.dtos.Request.UpdateBookRequest;
import com.semicolon.africa.dtos.Response.AddBookResponse;
import com.semicolon.africa.dtos.Response.ApiResponse;
import com.semicolon.africa.dtos.Response.RemoveBookResponse;
import com.semicolon.africa.dtos.Response.UpdateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private  BookServices bookServices;

    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequest addBookRequest) {
        try {
            AddBookResponse addBookResponse = bookServices.addBook(addBookRequest);
            return new ResponseEntity<>(addBookResponse, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove-book")
    public ResponseEntity<?> deleteBook(@RequestBody RemoveBookRequest removeBookRequest) {
        try {
            RemoveBookResponse removeBookResponse = bookServices.deleteBook(removeBookRequest);
            return new ResponseEntity<>(removeBookResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/update-book")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        try {
            UpdateBookResponse updateBookResponse = bookServices.updateBook(updateBookRequest);
            return new ResponseEntity<>(updateBookResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-book")
    public ResponseEntity<?> getAllBooks(){
        try {
            List<Book> books = bookServices.getAllBooks();
            return new ResponseEntity<>(new ApiResponse(true, books), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get-total-books")
    public ResponseEntity<?> getAllTotalBooks(){
        try {
            List<Book> books = bookServices.getAllBooks();
            return new ResponseEntity<>(new ApiResponse(true, books), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
