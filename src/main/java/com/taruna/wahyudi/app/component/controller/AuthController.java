package com.taruna.wahyudi.app.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taruna.wahyudi.app.component.model.dto.LoginUserRequest;
import com.taruna.wahyudi.app.component.model.dto.TokenResponse;
import com.taruna.wahyudi.app.component.service.AuthService;
import com.taruna.wahyudi.app.core.global.WebResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uri}/auth")
public class AuthController {

    private final AuthService authService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenResponse> login(@RequestBody String requestBody) {
        LoginUserRequest request = objectMapper.readValue(requestBody, LoginUserRequest.class);
        TokenResponse response = authService.auth(request);
        return WebResponse.<TokenResponse>builder().data(response).build();
    }
}
