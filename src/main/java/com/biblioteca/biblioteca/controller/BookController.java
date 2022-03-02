package com.biblioteca.biblioteca.controller;


import com.biblioteca.biblioteca.dto.BookDto;
import com.biblioteca.biblioteca.model.BookModel;
import com.biblioteca.biblioteca.service.BookService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveBook(@RequestBody BookDto bookDto) {

        BookModel bookModel = new BookModel();

        BeanUtils.copyProperties(bookDto, bookModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable ObjectId id) {

        Optional<BookModel> bookModelOptional = bookService.getById(id);
        if (!bookModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable ObjectId id) {

        Optional<BookModel> bookModelOptional = bookService.getById(id);
        if (!bookModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }

        bookService.delete(bookModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook (@PathVariable ObjectId id, @RequestBody BookDto bookDto){

        Optional<BookModel> bookModelOptional = bookService.getById(id);
        if (!bookModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }

        BookModel bookModel = bookModelOptional.get();
        BeanUtils.copyProperties(bookDto, bookModel);

        return ResponseEntity.status(HttpStatus.OK).body(bookService.save(bookModel));
    }
}
