package com.chewy.bookstore.services;

import java.util.List;
import com.chewy.bookstore.models.Book;

@Component
public class SuggestionService
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getSuggestions(long bookId)
    {
        return bookRepository.findAll();
    }
}
