package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Data.Model.Librarian;
import com.semicolon.africa.Data.Repositories.BookRepository;
import com.semicolon.africa.Data.Repositories.LibrarianRepository;
import com.semicolon.africa.Exception.*;
import com.semicolon.africa.dtos.Request.*;
import com.semicolon.africa.dtos.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrarianServicesImpl implements LibrarianServices {
    @Autowired
    LibrarianRepository librarianRepository;
    @Autowired
    private BookServices bookServices;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public RegisterLibrarianResponse registerLibrarian(RegisterLibrarianRequest registerLibrarianRequest){
        Librarian librarian = new Librarian();
        validate(registerLibrarianRequest);
        validateEmail(registerLibrarianRequest.getEmail());
        validatePassword(registerLibrarianRequest.getPassword());
        validatePhoneNumber(registerLibrarianRequest.getPhoneNumber());
        librarian.setFirstName(registerLibrarianRequest.getFirstName());
        librarian.setLastName(registerLibrarianRequest.getLastName());
        librarian.setEmail(registerLibrarianRequest.getEmail());
        librarian.setPassword(registerLibrarianRequest.getPassword());
        librarian.setPhoneNumber(registerLibrarianRequest.getPhoneNumber());
        librarianRepository.save(librarian);
        RegisterLibrarianResponse registerLibrarianResponse = new RegisterLibrarianResponse();
        registerLibrarianResponse.setMessage("Successfully registered");
        return registerLibrarianResponse;

}

    @Override
    public LoginLibrarianResponse loginLibrarian(LoginLibrarianRequest loginLibrarianRequest){

        Librarian foundLibrarian = librarianExists(loginLibrarianRequest.getEmail());
        validateEmail(loginLibrarianRequest.getEmail());
        validateLibrarianPassword(loginLibrarianRequest.getPassword(),foundLibrarian);
        foundLibrarian.setLoggedIn(true);
        LoginLibrarianResponse loginLibrarianResponse = new LoginLibrarianResponse();
        loginLibrarianResponse.setMessage("Successfully logged in");
        foundLibrarian.setLoggedIn(true);
        librarianRepository.save(foundLibrarian);
        return loginLibrarianResponse;
    }

    @Override
    public LogoutLibrarianResponse logoutLibrabrian(LogoutLibrarianRequest logoutLibrarianRequest){
        Librarian foundLibrarian = librarianExists(logoutLibrarianRequest.getEmail());
        foundLibrarian.setLoggedIn(true);
        LogoutLibrarianResponse logoutLibrarianResponse = new LogoutLibrarianResponse();
        logoutLibrarianResponse.setMessage("Successfully logged out");
        foundLibrarian.setLoggedIn(false);
        return logoutLibrarianResponse;
    }

    @Override
    public UpdateLibrarianResponse updateLibrarian(UpdateLibrarianRequest updateLibrarianRequest) {
        Librarian librarian = librarianExists(updateLibrarianRequest.getUserEmail());
        librarian.setFirstName(updateLibrarianRequest.getNewFirstName());
        librarian.setLastName(updateLibrarianRequest.getNewLastName());
        librarian.setPhoneNumber(updateLibrarianRequest.getNewPhoneNumber());
        librarianRepository.save(librarian);
        UpdateLibrarianResponse updateLibrarianResponse = new UpdateLibrarianResponse();
        updateLibrarianResponse.setMessage("Successfully updated");
        return updateLibrarianResponse;
    }

    @Override
    public DeleteLibrarianResponse deleteLibrarian(DeleteLibrarianRequest deleteLibrarianRequest) {
        Librarian librarian = librarianExists(deleteLibrarianRequest.getEmail());
        librarianRepository.delete(librarian);
        DeleteLibrarianResponse deleteLibrarianResponse = new DeleteLibrarianResponse();
        deleteLibrarianResponse.setMessage("Successfully deleted");
        return deleteLibrarianResponse;
    }
    @Override
    public AddBookRequest addLibrarianBook(AddBookRequest addBookRequest){
        Book book = new Book();
        Librarian librarian = librarianExists(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setTitle(addBookRequest.getTitle());
        book.setEdition(addBookRequest.getEdition());
        book.setDateOfPublication(addBookRequest.getDateOfPublication());
        book.setIsbn(addBookRequest.getIsbn());
        AddBookResponse addBookResponse = new AddBookResponse();
        librarian.getBookList().add(book);
        librarian = librarianRepository.save(librarian);
        addBookResponse.setMessage("Successfully added");
        bookRepository.count();
        return addBookRequest;

    }
    private void validate(RegisterLibrarianRequest registerLibrarianRequest){
        for (Librarian librarian1 : librarianRepository.findAll()) {
            if (librarian1.getEmail().equals(registerLibrarianRequest.getEmail())){
                throw new LibrarianNotFoundException("Librarian Already exist");
            }
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.contains(" ")){
            throw new InvalidEmailException("PhoneNumber cannot be Blank");
        }

        if (phoneNumber.length() != 11) {
            throw new InvalidPhoneNumberException("PhoneNumber must contain 11 characters");
        }
    }

    private void validateEmail(String email){

        if (email.contains(" ")){
            throw new InvalidEmailException("Email cannot contain spaces");
        }

        if (!email.contains("@")){
            throw new InvalidEmailException("Email must contain @");
        }
    }


    private void validateLibrarianPassword(String password, Librarian foundLibrarian) {
        validatePassword(password);

        if (!foundLibrarian.getPassword().equals(password)) {
            throw new InvalidPasswordException("Invalid password");
        }

    }


    private void validatePassword(String password){
        if (password.contains(" ")){
            throw new InvalidPasswordException("Password cannot contain spaces");
        }
        if (password.length() != 11) {
            throw new InvalidPasswordException("Password must be 11 characters");
        }
    }



    private Librarian librarianExists(String email){
        return librarianRepository.findByEmail(email).
                orElseThrow(()->new LibrarianNotFoundException("wrong Email"));
    }

    @Override
    public Long getTotalLibrarian(){
        return librarianRepository.count();
    }

    @Override
    public List<Librarian> getALibrarian() {
        return List.of();
    }

    @Override
    public List<Book> getAllBookForLibrarian(String email) {
        Librarian librarian = librarianRepository.findLibrarianByEmail(email);
        return bookServices.getAllBooks();
    }


}
