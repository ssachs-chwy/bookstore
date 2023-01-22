package com.chewy.bookstore.services;

import java.util.List;
import com.chewy.bookstore.models.Book;

public class SuggestionService
{
    @Autowired
    private BookRepository bookRepository;

    private List<SuggestionDecorator> decorators;

    public SuggestionService() {
        deocrators.add(new AuthorDecorator());
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
        List<Book> answer = new List<Book>();

        for (SuggestionDecorator decorator : decorators) {
            answer = decorator.decorate(answer, query, allBooks);
        }

        return answer;
    }
}
