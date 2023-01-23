package com.chewy.bookstore.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.repositories.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List <Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Book> updateBook(@PathVariable(value = "id") Long bookId,
        @Valid @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(bookId).orElse(null);

        book.setTitle(bookDetails.getTitle());
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public Map <String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        bookRepository.delete(book);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}