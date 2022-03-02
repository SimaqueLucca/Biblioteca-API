package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.BookModel;
import com.biblioteca.biblioteca.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll(){
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel save(BookModel bookModel){
        return bookRepository.save(bookModel);
    }

    public Optional<BookModel> getById(ObjectId id){
        return bookRepository.findById(id);
    }

    @Transactional
    public void delete(BookModel bookModel){
       bookRepository.delete(bookModel);
    }
}
