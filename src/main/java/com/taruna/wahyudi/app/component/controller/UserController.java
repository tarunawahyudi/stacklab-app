package com.taruna.wahyudi.app.component.controller;

import com.taruna.wahyudi.app.component.model.dto.RegisterUserRequest;
import com.taruna.wahyudi.app.component.service.UserService;
import com.taruna.wahyudi.app.core.global.WebResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Users")
@RequestMapping("${application.api.uri}/users")
public class UserController {

    private final UserService userService;

    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@Valid @RequestBody RegisterUserRequest requestBody) {
        userService.register(requestBody);
        return WebResponse.<String>builder().data("success").build();
    }
}
