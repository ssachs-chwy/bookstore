package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.inject.Provider;

@Service
public class SuggestionService
{
    private BookRepository bookRepository;
    private Provider<SuggestionDecoratorFactory> factoryProvider;

    @Autowired
    public SuggestionService(BookRepository bookRepository, Provider<SuggestionDecoratorFactory> factoryProvider) {
        this.bookRepository = bookRepository;
        this.factoryProvider = factoryProvider;
    }

    public List<Book> getSuggestions(long bookId)
    {
        Book query = bookRepository.findById(bookId).orElse(null);
        List<Book> allBooks = bookRepository.findAll();
        return decorateSuggestions(query, allBooks);
    }

    private List<Book> decorateSuggestions(Book query, List<Book> allBooks) {
        List<Book> answer = new ArrayList<Book>();

        for (SuggestionDecorator decorator : getDecorators()) {
            answer = decorator.decorate(answer, query, allBooks);
        }

        return answer;
    }

    private List<SuggestionDecorator> getDecorators() {
        SuggestionDecoratorFactory factory = factoryProvider.get();
        return factory.getDecorators();
    }

}
