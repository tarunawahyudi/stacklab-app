package com.taruna.wahyudi.app.component.service.transaction;

import com.taruna.wahyudi.app.component.model.dto.RegisterUserRequest;
import com.taruna.wahyudi.app.component.model.entity.User;
import com.taruna.wahyudi.app.component.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public final class UserServiceSaver extends UserServiceTransaction {

    private final UserRepository userRepository;

    public void save(RegisterUserRequest request) {
        String password = super.getApplicationConfig().passwordEncoder().encode(request.password());
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(password)
                .build();
        userRepository.save(user);
    }
}
