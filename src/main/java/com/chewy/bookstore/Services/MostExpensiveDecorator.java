package com.chewy.bookstore.services;

import com.chewy.bookstore.models.Book;

public class MostExpensiveDecorator implements SuggestionDecorator {
    private int NumToSelect = 5;

    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        return suggestions.orderBy(b -> b.getPrice()).range(0, NumToSelect);
    }
}