package com.semicolon.africa.Data.Repositories;

import com.semicolon.africa.Data.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAuthor(String author);
}
