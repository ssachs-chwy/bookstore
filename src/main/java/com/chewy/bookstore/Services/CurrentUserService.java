package com.chewy.bookstore.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

@Component
public class CurrentUserService {
    private boolean isInStore;

    public boolean getIsInStore() {
        return isInStore;
    }

    public void setIsInStore(boolean isInStore) {
        this.isInStore = isInStore;
    }
}