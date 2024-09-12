package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Data.Repositories.BookRepository;
import com.semicolon.africa.dtos.Request.AddBookRequest;
import com.semicolon.africa.dtos.Request.RemoveBookRequest;
import com.semicolon.africa.dtos.Request.UpdateBookRequest;
import com.semicolon.africa.dtos.Response.AddBookResponse;
import com.semicolon.africa.dtos.Response.RemoveBookResponse;
import com.semicolon.africa.dtos.Response.UpdateBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServicesImpl implements BookServices {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setAuthor(addBookRequest.getAuthor());
        book.setTitle(addBookRequest.getTitle());
        book.setIsbn(addBookRequest.getIsbn());
        book.setEdition(addBookRequest.getEdition());
        book.setDateOfPublication(addBookRequest.getDateOfPublication());
        book.setIsbn(addBookRequest.getIsbn());
        bookRepository.save(book);

        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setMessage("Book added successfully");
        return addBookResponse;
    }

    @Override
    public RemoveBookResponse deleteBook(RemoveBookRequest removeBookRequest) {
        Book book = new Book();
        book.setTitle(removeBookRequest.getTitle());
        book.setIsbn(removeBookRequest.getIsbn());
        book.setAuthor(removeBookRequest.getAuthor());
        bookRepository.save(book);

        RemoveBookResponse removeBookResponse = new RemoveBookResponse();
        removeBookResponse.setMessage("Book removed successfully");
        return removeBookResponse;
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {
        Book book = new Book();
        book.setTitle(updateBookRequest.getTitle());
        book.setIsbn(updateBookRequest.getIsbn());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setEdition(updateBookRequest.getEdition());
        book.setDateOfPublication(updateBookRequest.getDateOfPublication());
        bookRepository.save(book);
        Book newBook = new Book();
        newBook.setTitle(updateBookRequest.getNewTitle());
        newBook.setIsbn(updateBookRequest.getNewIsbn());
        newBook.setAuthor(updateBookRequest.getNewAuthor());
        newBook.setEdition(updateBookRequest.getNewEdition());
        newBook.setDateOfPublication(updateBookRequest.getNewDateOfPublication());
        bookRepository.save(newBook);

        UpdateBookResponse updateBookResponse = new UpdateBookResponse();
        updateBookResponse.setMessage("Book updated successfully");
        return updateBookResponse;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Long getTotalBook() {
        return bookRepository.count();
    }
}
