package com.chewy.bookstore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.RequestScope;

@Configuration
public class BookstoreConfig {

    @Bean
    @RequestScope
    public CurrentUserService getCurrentUserService() {
        return new CurrentUserService();
    }

}