package com.chewy.bookstore.models;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.stereotype.Component;

@Component
@RequestScope
public class CurrentUser {
    private boolean isInStore;

    public boolean getIsInStore() {
        return isInStore;
    }

    public void setIsInStore(boolean isInStore) {
        this.isInStore = isInStore;
    }
}