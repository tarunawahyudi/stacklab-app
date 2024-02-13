package com.taruna.wahyudi.app.component.service;

import com.taruna.wahyudi.app.core.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public abstract class ApplicationService {

    @Autowired
    private ApplicationConfig applicationConfig;

    protected ApplicationConfig getApplicationConfig() {
        return this.applicationConfig;
    }
}
