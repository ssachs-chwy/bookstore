package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestionService
{
    @Autowired
    private BookRepository bookRepository;

    private List<SuggestionDecorator> decorators;

    @Autowired
    public SuggestionService(ServiceDecoratorFactory factory) {
        decorators = factory.getDecorators();
    }

    public List<Book> getSuggestions(long bookId)
    {
        Book query = bookRepository.findById(bookId).orElse(null);
        List<Book> allBooks = bookRepository.findAll();
        return decorateSuggestions(query, allBooks);
    }

    private List<Book> decorateSuggestions(Book query, List<Book> allBooks) {
        List<Book> answer = new ArrayList<Book>();

        for (SuggestionDecorator decorator : decorators) {
            answer = decorator.decorate(answer, query, allBooks);
        }

        return answer;
    }
}
