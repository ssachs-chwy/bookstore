package com.chewy.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.services.SuggestionService;


@RestController
@RequestMapping("/api/v1")
public class SuggestionsController {
    @Autowired
    private SuggestionService svc;

    @GetMapping("/suggestions/{bookId}")
    public List<Book> getSuggestions(@PathVariable(value = "bookId") Long bookId) {
        return svc.getSuggestions();
    }

}