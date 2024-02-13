package com.taruna.wahyudi.app.component.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterUserRequest(
        @NotBlank(message = "{validation.required}")
        String name,
        @NotBlank(message = "{validation.required}")
        @Email(message = "{validation.email}")
        String email,
        @NotBlank(message = "{validation.required}")
        String password
) {}
