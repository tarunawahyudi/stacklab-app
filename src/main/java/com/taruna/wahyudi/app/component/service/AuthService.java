package com.taruna.wahyudi.app.component.service;

import com.taruna.wahyudi.app.component.model.dto.LoginUserRequest;
import com.taruna.wahyudi.app.component.model.dto.TokenResponse;

public interface AuthService {
    TokenResponse auth(LoginUserRequest request);
}