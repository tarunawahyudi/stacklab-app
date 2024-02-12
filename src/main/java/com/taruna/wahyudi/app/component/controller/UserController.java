package com.taruna.wahyudi.app.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taruna.wahyudi.app.component.model.dto.RegisterUserRequest;
import com.taruna.wahyudi.app.component.service.UserService;
import com.taruna.wahyudi.app.core.global.WebResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uri}/users")
public class UserController {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    @SneakyThrows
    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody String requestBody) {
        RegisterUserRequest request = objectMapper.readValue(requestBody, RegisterUserRequest.class);
        userService.register(request);
        return WebResponse.<String>builder().data("success").build();
    }
}
