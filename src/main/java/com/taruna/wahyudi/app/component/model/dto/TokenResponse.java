package com.taruna.wahyudi.app.component.model.dto;

import lombok.Builder;

@Builder
public record TokenResponse(String token, String expiredAt) {}
