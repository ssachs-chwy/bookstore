package com.chewy.bookstore.services;

import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {
    private boolean isInStore;

    public boolean getIsInStore() {
        return isInStore;
    }

    public void setIsInStore(boolean isInStore) {
        this.isInStore = isInStore;
    }
}