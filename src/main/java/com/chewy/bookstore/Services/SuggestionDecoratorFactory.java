package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.stereotype.Component;
import com.chewy.bookstore.models.CurrentUser;
import javax.inject.Provider;

@Component
@RequestScope
public class SuggestionDecoratorFactory
{
    private Provider<CurrentUserSuggestionStrategy> strategyProvider;

    @Autowired
    public SuggestionDecoratorFactory(Provider<CurrentUserSuggestionStrategy> strategyProvider)
    {
        this.strategyProvider = strategyProvider;
    }

    public List<SuggestionDecorator> getDecorators()
    {
        List<SuggestionDecorator> decorators = new ArrayList<SuggestionDecorator>();
        decorators.add(new AuthorDecorator());

        CurrentUserSuggestionStrategy strategy = strategyProvider.get();
        decorators.addAll(strategy.getCurrentUserSuggestionDecorators());

        decorators.add(new MostExpensiveDecorator());
        return decorators;
    }

}