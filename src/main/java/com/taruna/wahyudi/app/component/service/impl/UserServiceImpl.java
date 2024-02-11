package com.taruna.wahyudi.app.component.service.impl;

import com.taruna.wahyudi.app.component.model.dto.RegisterUserRequest;
import com.taruna.wahyudi.app.component.service.UserService;
import com.taruna.wahyudi.app.component.service.transaction.UserServiceSaver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServiceSaver userServiceSaver;

    @Override
    public void register(RegisterUserRequest request) {
        userServiceSaver.save(request);
    }
}
