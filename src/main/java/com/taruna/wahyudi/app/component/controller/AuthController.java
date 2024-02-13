package com.taruna.wahyudi.app.component.controller;

import com.taruna.wahyudi.app.component.model.dto.LoginUserRequest;
import com.taruna.wahyudi.app.component.model.dto.TokenResponse;
import com.taruna.wahyudi.app.component.service.AuthService;
import com.taruna.wahyudi.app.core.global.WebResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "Authentication")
@RequestMapping("${application.api.uri}/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenResponse> login(@RequestBody LoginUserRequest requestBody) {
        TokenResponse response = authService.auth(requestBody);
        return WebResponse.<TokenResponse>builder().data(response).build();
    }
}
