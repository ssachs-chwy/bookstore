package com.chewy.bookstore.services;

import com.chewy.bookstore.models.Book;

public interface SuggestionDecorator {
    List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks);
}