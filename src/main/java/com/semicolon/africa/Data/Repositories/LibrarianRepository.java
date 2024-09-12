package com.semicolon.africa.Data.Repositories;

import com.semicolon.africa.Data.Model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface LibrarianRepository extends MongoRepository<Librarian, String> {
    Optional<Librarian> findByEmail(String email);
    List<Librarian> findByFirstName(String firstName);
    Librarian findLibrarianByEmail(String email);
}
