package com.chewy.bookstore.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.stereotype.Component;
import com.chewy.bookstore.models.CurrentUser;

@Component
@RequestScope
public class SuggestionDecoratorFactory
{
    public List<SuggestionDecorator> getDecorators()
    {
        List<SuggestionDecorator> decorators = new ArrayList<SuggestionDecorator>();
        decorators.add(new AuthorDecorator());

        decorators.addAll(getStrategy().getCurrentUserSuggestionDecorators());

        decorators.add(new MostExpensiveDecorator());
        return decorators;
    }

    @Lookup
    protected CurrentUserSuggestionStrategy getStrategy() { return null; }

}