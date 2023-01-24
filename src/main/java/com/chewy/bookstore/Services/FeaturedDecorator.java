package com.chewy.bookstore.services;

import java.util.List;
import com.chewy.bookstore.models.Book;

public class FeaturedDecorator implements SuggestionDecorator {
    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        for (Book book : allBooks) {
            if (book.getId() == query.getId()) { continue; }
            
            if (book.getIsFeatured() &&
                book.getPublisher().equals(query.getPublisher())) {
                suggestions.add(book);
            }
        }

        return suggestions;
    }
}