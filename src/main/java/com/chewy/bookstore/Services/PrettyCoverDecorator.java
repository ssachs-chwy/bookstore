package com.chewy.bookstore.services;

import java.util.Collections;
import java.util.List;
import com.chewy.bookstore.models.Book;

public class PrettyCoverDecorator implements SuggestionDecorator {
    public List<Book> decorate(List<Book> suggestions, Book query, List<Book> allBooks)
    {
        List<Book> answer = suggestions;

        for (Book book : allBooks) {
            if (book.getCoverPrettiness() > query.getCoverPrettiness()) {
                answer.add(book);
            }
        }

        return answer;
    }
}