package com.chewy.bookstore.services;

import java.util.List;
import com.chewy.bookstore.models.Book;
import com.chewy.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SuggestionService
{
    @Autowired
    private BookRepository bookRepository;

    private List<SuggestionDecorator> decorators;

    public SuggestionService() {
        decorators = new ArrayList<SuggestionDecorator>();
        decorators.add(new AuthorDecorator());
        decorators.add(new FeaturedDecorator());
        decorators.add(new MostExpensiveDecorator());
    }

    public List<Book> getSuggestions(long bookId)
    {
        Book query = bookRepository.findById(bookId);
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
