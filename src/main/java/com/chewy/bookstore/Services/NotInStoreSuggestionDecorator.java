package com.chewy.bookstore.services;

import java.util.*;

public class NotInStoreSuggestionDecorator implements CurrentUserSuggestionStrategy
{
    public List<SuggestionDecorator> getCurrentUserSuggestionDecorators()
    {
        return Arrays.asList(new FeaturedDecorator());
    }
}