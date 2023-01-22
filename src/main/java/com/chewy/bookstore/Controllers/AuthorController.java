package com.chewy.authorstore.controllers;

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
import com.chewy.bookstore.models.Author;
import com.chewy.bookstore.repositories.AuthorRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        return ResponseEntity.ok().body(author);
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId,
        @Valid @RequestBody Author authorDetails) {
        Author author = authorRepository.findById(authorId).orElse(null);

        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.setLastName());

        final Author updatedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/authors/{id}")
    public Map <String, Boolean> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);

        authorRepository.delete(author);
        Map <String, Boolean> response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}