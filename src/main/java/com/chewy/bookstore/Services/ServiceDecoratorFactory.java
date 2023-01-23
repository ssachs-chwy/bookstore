package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ServiceDecoratorFactory
{
    public List<SuggestionDecorator> getDecorators()
    {
        List<SuggestionDecorator> decorators = new ArrayList<SuggestionDecorator>();
        decorators.add(new AuthorDecorator());
        decorators.add(new FeaturedDecorator());
        decorators.add(new PrettyCoverDecorator());
        decorators.add(new MostExpensiveDecorator());
        return decorators;
    }
}