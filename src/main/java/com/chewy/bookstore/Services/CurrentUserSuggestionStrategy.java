package com.chewy.bookstore.services;

import java.util.List;

interface CurrentUserSuggestionStrategy
{
    List<SuggestionDecorator> getCurrentUserSuggestionDecorators();
}