package com.chewy.bookstore.services;

import com.chewy.bookstore.models.Book;

public class AuthorDecorator implements SuggestionDecorator {
    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        for (Book book : allBooks) {
            if (book.authorId == query.authorId) {
                suggestions.add(book);
            }
        }

        return suggestions;
    }
}