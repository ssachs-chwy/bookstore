package com.chewy.bookstore.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.context.annotation.RequestScope;
import com.chewy.bookstore.models.CurrentUser;
import com.chewy.bookstore.services.*;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class BookstoreConfig
{
    @Lookup
    protected CurrentUser getCurrentUser() { return null; }

    @Bean
    @RequestScope
    public CurrentUserSuggestionStrategy getCurrentUserSuggestionStrategy()
    {
        CurrentUser usr = getCurrentUser();
        if (usr.getIsInStore()) {
            return new IsInStoreSuggestionDecorator();
        }
        else {
            return new NotInStoreSuggestionDecorator();
        }
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI();
    }
}