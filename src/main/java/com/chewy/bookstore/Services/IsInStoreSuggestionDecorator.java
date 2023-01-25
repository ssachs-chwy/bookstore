package com.chewy.bookstore.services;

import java.util.*;

public class IsInStoreSuggestionDecorator implements CurrentUserSuggestionStrategy
{
    public List<SuggestionDecorator> getCurrentUserSuggestionDecorators()
    {
        return Arrays.asList(new PrettyCoverDecorator());
    }
}