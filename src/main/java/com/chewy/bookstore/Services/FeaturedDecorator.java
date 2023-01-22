package com.chewy.bookstore.services;

import com.chewy.bookstore.models.Book;

public class FeaturedDecorator implements SuggestionDecorator {
    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        for (Book book : allBooks) {
            if (book.getIsFeatured() &&
                book.getPublisher.equals(query.getPublisher())) {
                suggestions.add(book);
            }
        }

        return suggestions;
    }
}