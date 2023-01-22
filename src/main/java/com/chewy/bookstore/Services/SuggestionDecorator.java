package com.chewy.bookstore.services;

import com.chewy.bookstore.models.Book;
import java.util.List;

public interface SuggestionDecorator {
    List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks);
}