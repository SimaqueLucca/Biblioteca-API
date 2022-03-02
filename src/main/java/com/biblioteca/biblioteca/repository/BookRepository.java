package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.BookModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookModel, ObjectId> {
}
