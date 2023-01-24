package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ServiceDecoratorFactory
{
    private CurrentUserService svc;

    @Autowired
    public ServiceDecoratorFactory(CurrentUserService svc)
    {
        this.svc = svc;
    }

    public List<SuggestionDecorator> getDecorators()
    {
        List<SuggestionDecorator> decorators = new ArrayList<SuggestionDecorator>();
        decorators.add(new AuthorDecorator());

        if (svc.getIsInStore()) {
            decorators.add(new PrettyCoverDecorator());
        }
        else {
            decorators.add(new FeaturedDecorator());
        }

        decorators.add(new MostExpensiveDecorator());
        return decorators;
    }
}