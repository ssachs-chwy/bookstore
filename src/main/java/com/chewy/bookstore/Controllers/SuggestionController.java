package com.chewy.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.services.SuggestionService;
import com.chewy.bookstore.services.CurrentUserService;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/api/v1/suggestions")
public class SuggestionController {
    private SuggestionService suggestionSvc;
    private CurrentUserService currentUserSvc;
    private final String HEADER_IS_IN_STORE = "x-chewy-is-in-store";

    @Autowired
    public SuggestionController(SuggestionService suggestionSvc, CurrentUserService currentUserSvc) {
        this.suggestionSvc = suggestionSvc;
        this.currentUserSvc = currentUserSvc;
    }

    @GetMapping("/{bookId}")
    public List<Book> getSuggestions(@RequestHeader Map<String, String> headers, @PathVariable(value = "bookId") Long bookId) {
        if (headers.containsKey(HEADER_IS_IN_STORE)) {
            currentUserSvc.setIsInStore(true);
        }
        else {
            currentUserSvc.setIsInStore(false);
        }

        return suggestionSvc.getSuggestions(bookId);
    }

}