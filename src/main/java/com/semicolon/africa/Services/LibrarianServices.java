package com.semicolon.africa.Services;

import com.semicolon.africa.Data.Model.Book;
import com.semicolon.africa.Data.Model.Librarian;
import com.semicolon.africa.dtos.Request.*;
import com.semicolon.africa.dtos.Response.*;

import java.util.List;

public interface LibrarianServices {
    RegisterLibrarianResponse registerLibrarian(RegisterLibrarianRequest registerLibrarianRequest);
    LoginLibrarianResponse loginLibrarian(LoginLibrarianRequest loginLibrarianRequest);
    LogoutLibrarianResponse logoutLibrabrian(LogoutLibrarianRequest logoutLibrarianRequest);
    UpdateLibrarianResponse updateLibrarian(UpdateLibrarianRequest updateLibrarianRequest);
    DeleteLibrarianResponse deleteLibrarian(DeleteLibrarianRequest deleteLibrarianRequest);
    Long getTotalLibrarian();
    List<Librarian> getALibrarian();
    List<Book> getAllBookForLibrarian(String email);
}

