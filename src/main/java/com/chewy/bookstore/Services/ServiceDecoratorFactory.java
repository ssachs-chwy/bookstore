package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.stereotype.Component;

@Component
@RequestScope
public class ServiceDecoratorFactory
{
    public List<SuggestionDecorator> getDecorators()
    {
        CurrentUserService svc = getCurrentUserService1();
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

    @Lookup
    protected CurrentUserService getCurrentUserService1() { return null; }

}