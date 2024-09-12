package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Repositories.BookRepository;
import com.semicolon.africa.dtos.Request.*;
import com.semicolon.africa.dtos.Response.AddBookResponse;
import com.semicolon.africa.dtos.Response.DeleteLibrarianResponse;
import com.semicolon.africa.dtos.Response.RemoveBookResponse;
import com.semicolon.africa.dtos.Response.UpdateBookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServicesTest {
    @Autowired
    private BookServices bookServices;
    @Autowired
    private BookRepository bookRepository;
    @Test
    void testThatABookCanBeAdded() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setAuthor("John Doe");
        addBookRequest.setTitle("Book Title");
        addBookRequest.setEdition("2001");
        addBookRequest.setIsbn("ISBN 123");
        addBookRequest.setDateOfPublication("01-01-2010");
        bookServices.addBook(addBookRequest);
        AddBookResponse addBookResponse = bookServices.addBook(addBookRequest);
        assertThat(addBookResponse).isNotNull();
        assertThat(addBookResponse.getMessage()).isEqualTo("Book added successfully");
    }
    @Test
    void testThatABookCanBeUpdated() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setAuthor("John Doe");
        addBookRequest.setTitle("Book Title");
        addBookRequest.setEdition("2001");
        addBookRequest.setIsbn("ISBN 123");
        addBookRequest.setDateOfPublication("01-01-2010");
        bookServices.addBook(addBookRequest);
        assertThat(addBookRequest).isNotNull();
        UpdateBookRequest updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setAuthor("John Doe");
        updateBookRequest.setTitle("Book Title");
        updateBookRequest.setEdition("2001");
        updateBookRequest.setIsbn("ISBN 123");
        updateBookRequest.setDateOfPublication("01-01-2010");
        bookServices.updateBook(updateBookRequest);
        assertThat(updateBookRequest).isNotNull();
        UpdateBookRequest newUpdateBookRequest = new UpdateBookRequest();
        updateBookRequest.setNewTitle("New Title");
        updateBookRequest.setNewEdition("2001");
        updateBookRequest.setNewIsbn("ISBN 123");
        updateBookRequest.setNewDateOfPublication("01-01-2010");
        bookServices.updateBook(updateBookRequest);
        UpdateBookResponse updateBookResponse = bookServices.updateBook(updateBookRequest);
        assertThat(updateBookResponse).isNotNull();
        assertThat(updateBookResponse.getMessage()).isEqualTo("Book updated successfully");


    }
    @Test
    void testThatABookCanBeDeleted() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setAuthor("John Doe");
        addBookRequest.setTitle("Book Title");
        addBookRequest.setEdition("2001");
        addBookRequest.setIsbn("ISBN 123");
        addBookRequest.setDateOfPublication("01-01-2010");
        bookServices.addBook(addBookRequest);
        RemoveBookRequest removeBookRequest = new RemoveBookRequest();
        removeBookRequest.setAuthor("John Doe");
        removeBookRequest.setTitle("Book Title");
        bookServices.deleteBook(removeBookRequest);
        RemoveBookResponse removeBookResponse = bookServices.deleteBook(removeBookRequest);
        assertThat(removeBookResponse).isNotNull();
        assertThat(removeBookResponse.getMessage()).isEqualTo("Book removed successfully");


    }

//    @Test
//    void testThatGetAllBooks() {
//        AddBookRequest addBookRequest = new AddBookRequest();
//        addBookRequest.setAuthor("John Doe");
//        addBookRequest.setTitle("Book Title");
//        addBookRequest.setEdition("2001");
//        addBookRequest.setIsbn("ISBN 123");
//        addBookRequest.setDateOfPublication("01-01-2010");
//        bookServices.addBook(addBookRequest);
//        assertThat(addBookRequest).isNotNull();
//        assertThat(bookRepository.count()).isEqualTo(1);
//    }

}
