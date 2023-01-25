package com.chewy.bookstore.services;

import java.util.List;

public interface CurrentUserSuggestionStrategy
{
    List<SuggestionDecorator> getCurrentUserSuggestionDecorators();
}