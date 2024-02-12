package com.taruna.wahyudi.app.component.service;

import com.taruna.wahyudi.app.core.config.ApplicationConfig;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public abstract class ApplicationService {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private Validator validator;

    protected ApplicationConfig getApplicationConfig() {
        return this.applicationConfig;
    }

    protected void validate(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
