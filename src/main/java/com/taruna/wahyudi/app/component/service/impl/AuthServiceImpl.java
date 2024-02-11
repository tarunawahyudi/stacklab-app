package com.taruna.wahyudi.app.component.service.impl;

import com.taruna.wahyudi.app.component.model.dto.LoginUserRequest;
import com.taruna.wahyudi.app.component.model.dto.TokenResponse;
import com.taruna.wahyudi.app.component.service.AuthService;
import com.taruna.wahyudi.app.component.service.transaction.AuthServiceFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthServiceFetcher authServiceFetcher;

    @Override
    public TokenResponse auth(LoginUserRequest request) {
        return authServiceFetcher.login(request);
    }
}
