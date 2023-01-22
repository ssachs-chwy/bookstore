package com.chewy.bookstore.services;

import java.util.Collections;
import com.chewy.bookstore.models.Book;

public class MostExpensiveDecorator implements SuggestionDecorator {
    private int NumToSelect = 5;

    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        List<Book> answer = suggestions;

        Collections.sort(answer, (b1, b2) -> {
            return b2.getPrice() - b1.getPrice();
        })

        return answer.limit(NumToSelect);
    }
}