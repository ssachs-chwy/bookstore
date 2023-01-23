package com.chewy.bookstore.services;

import java.util.Collections;
import java.util.List;
import com.chewy.bookstore.models.Book;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostExpensiveDecorator implements SuggestionDecorator {
    private int MaxNumToSelect = 5;

    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        List<Book> answer = suggestions.stream().distinct().collect(Collectors.toList());

        Collections.sort(answer, (b1, b2) -> {
            return b2.getPrice() - b1.getPrice();
        });

        int numToSelect = Math.min(MaxNumToSelect, answer.size());

        return answer.subList(0, numToSelect);
    }
}