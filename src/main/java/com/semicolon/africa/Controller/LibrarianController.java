package com.semicolon.africa.Controller;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Data.Model.Librarian;
import com.semicolon.africa.Services.BookServices;
import com.semicolon.africa.Services.LibrarianServices;
import com.semicolon.africa.dtos.Request.*;
import com.semicolon.africa.dtos.Response.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/librarian")
@AllArgsConstructor
public class LibrarianController {
    @Autowired
    private BookServices bookServices;
    @Autowired
    private LibrarianServices librarianServices;

    @PostMapping("/register-librarian")
    public ResponseEntity<?> registerLibrarian(@RequestBody RegisterLibrarianRequest registerLibrarianRequest) {
        try {
            RegisterLibrarianResponse registerLibrarianResponse = librarianServices.registerLibrarian(registerLibrarianRequest);
            return new ResponseEntity<>(registerLibrarianResponse, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login-librarian")
    public ResponseEntity<?> loginLibrarian(@RequestBody LoginLibrarianRequest loginLibrarianRequest) {
        try {
            LoginLibrarianResponse loginLibrarianResponse = librarianServices.loginLibrarian(loginLibrarianRequest);
            return new ResponseEntity<>(loginLibrarianResponse, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-a-librarian")
    public ResponseEntity<?> getALibrarian() {
        try {
            List<Librarian> librarianList = librarianServices.getALibrarian();
            return new ResponseEntity<>(librarianList, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-total-librarian")
    public ResponseEntity<?> getALibrarianTotal() {
        try {
            List<Librarian> librarianList = librarianServices.getALibrarian();
            return new ResponseEntity<>(librarianList, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-librarian")
    public ResponseEntity<?> deleteLibrarian(@RequestBody DeleteLibrarianRequest deleteLibrarianRequest) {
        try {
            DeleteLibrarianResponse deleteLibrarianResponse = librarianServices.deleteLibrarian(deleteLibrarianRequest);
            return new ResponseEntity<>(deleteLibrarianResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/update-librarian")
    public ResponseEntity<?> updateLibrarian(@RequestBody UpdateLibrarianRequest updateLibrarianRequest) {
        try {
            UpdateLibrarianResponse updateLibrarianResponse = librarianServices.updateLibrarian(updateLibrarianRequest);
            return new ResponseEntity<>(updateLibrarianResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add-book-to-librarian")
    public ResponseEntity<?> addBookToLibrarian(@RequestBody AddBookRequest addBookRequest) {
        try{
            AddBookResponse addBookResponse = bookServices.addBook(addBookRequest);
            return new ResponseEntity<>(addBookResponse, HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get-all-books-for-a-librarian")
    public ResponseEntity<?> getAllBooksForALibrarian() {
        try {
            List<Book> bookList = librarianServices.getAllBookForLibrarian("librarianId");
            return new ResponseEntity<>( new ApiResponse(true, bookList), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
