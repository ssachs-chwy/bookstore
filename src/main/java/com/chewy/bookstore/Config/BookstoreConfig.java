package com.chewy.bookstore.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import com.chewy.bookstore.models.CurrentUser;
import com.chewy.bookstore.services.*;
import io.swagger.v3.oas.models.OpenAPI;
import javax.inject.Provider;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class BookstoreConfig
{
    @Autowired
    protected Provider<CurrentUser> userProvider;

    @Bean
    @RequestScope
    public CurrentUserSuggestionStrategy getCurrentUserSuggestionStrategy()
    {
        CurrentUser usr = userProvider.get();
        if (usr.getIsInStore()) {
            return new IsInStoreSuggestionDecorator();
        }
        else {
            return new NotInStoreSuggestionDecorator();
        }
    }

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI();
    }
}