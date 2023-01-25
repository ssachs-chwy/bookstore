package com.chewy.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import com.chewy.bookstore.services.CurrentUserService;


//@Configuration
public class BookstoreConfig {

//    @Bean
//    @RequestScope
    public CurrentUserService getCurrentUserService() {
        return new CurrentUserService();
    }

}