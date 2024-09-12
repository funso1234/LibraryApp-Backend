package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Data.Model.Librarian;
import com.semicolon.africa.Data.Repositories.LibrarianRepository;
import com.semicolon.africa.Exception.InvalidEmailException;
import com.semicolon.africa.Exception.InvalidPasswordException;
import com.semicolon.africa.Exception.LibrarianNotFoundException;
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

    @Override
    public RegisterLibrarianResponse registerLibrarian(RegisterLibrarianRequest registerLibrarianRequest){
        Librarian librarian = new Librarian();
        validateEmail(registerLibrarianRequest.getEmail(), librarian);
        validateLibrarianPassword(registerLibrarianRequest.getPassword(), librarian);
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
        validatePassword(loginLibrarianRequest.getPassword(), foundLibrarian);
        foundLibrarian.setLoggedIn(true);
        LoginLibrarianResponse loginLibrarianResponse = new LoginLibrarianResponse();
        loginLibrarianResponse.setMessage("Successfully logged in");
        foundLibrarian.setLoggedIn(true);
        return loginLibrarianResponse;
    }

    @Override
    public LogoutLibrarianResponse logoutLibrabrian(LogoutLibrarianRequest logoutLibrarianRequest){
        Librarian foundLibrarian = new Librarian();
        foundLibrarian.setLoggedIn(true);
        LogoutLibrarianResponse logoutLibrarianResponse = new LogoutLibrarianResponse();
        logoutLibrarianResponse.setMessage("Successfully logged out");
        foundLibrarian.setLoggedIn(false);
        return logoutLibrarianResponse;
    }

    @Override
    public UpdateLibrarianResponse updateLibrarian(UpdateLibrarianRequest updateLibrarianRequest) {
        Librarian librarian = librarianExists(updateLibrarianRequest.getEmail());
        validateEmail(updateLibrarianRequest.getEmail(), librarian);
        librarian.setFirstName(updateLibrarianRequest.getFirstName());
        librarian.setLastName(updateLibrarianRequest.getLastName());
        librarian.setEmail(updateLibrarianRequest.getEmail());
        librarian.setPhoneNumber(updateLibrarianRequest.getPhoneNumber());
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

    private void validateEmail(String email, Librarian foundLibrarian){
        if(foundLibrarian.getEmail().equalsIgnoreCase(email)){
            throw new InvalidEmailException("Invalid email");
        }
    }

    private void validateLibrarianPassword(String password, Librarian foundLibrarian){
        if(foundLibrarian.getPassword().length() != 11){
            throw new InvalidPasswordException("Password must be 11 characters");
        }
    }

    private void validatePassword(String password, Librarian librarian){
        if(!(librarian.getPassword().matches(password))){
            throw new InvalidPasswordException("Invalid password");
        }
    }
    private Librarian librarianExists(String email){
        return librarianRepository.findByEmail(email).
                orElseThrow(()->new LibrarianNotFoundException("Librarian with email "+email+" not found"));
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
        if(!librarian.isLoggedIn()){
            throw new LibrarianNotFoundException("Librarian with email "+email+" not found");
        }
        return bookServices.getAllBooks();
    }

}
