package com.chewy.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chewy.bookstore.models.SuggestionSearch;
import com.chewy.bookstore.services.SuggestionService;
import com.chewy.bookstore.models.CurrentUser;
import com.chewy.bookstore.models.Book;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/suggestion-searches")
public class SuggestionController {
    private SuggestionService suggestionSvc;

    @Autowired
    public SuggestionController(SuggestionService suggestionSvc) {
        this.suggestionSvc = suggestionSvc;
    }

    @PostMapping("/")
    public List<Book> getSuggestions(@RequestBody SuggestionSearch search) {
        CurrentUser currentUser = getCurrentUser();
        currentUser.setIsInStore(search.isInStore);

        return suggestionSvc.getSuggestions(search.bookId);
    }

    @Lookup
    protected CurrentUser getCurrentUser() { return null; }

}