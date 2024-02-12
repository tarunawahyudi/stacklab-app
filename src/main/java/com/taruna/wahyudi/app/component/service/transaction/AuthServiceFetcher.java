package com.taruna.wahyudi.app.component.service.transaction;
import com.taruna.wahyudi.app.component.model.dto.LoginUserRequest;
import com.taruna.wahyudi.app.component.model.dto.TokenResponse;
import com.taruna.wahyudi.app.component.model.entity.User;
import com.taruna.wahyudi.app.component.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public final class AuthServiceFetcher extends AuthServiceTransaction {

    private final UserRepository userRepository;

    public TokenResponse login(LoginUserRequest request) {
        User user = userRepository.findByEmailAndPassword(request.email(), request.password())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is wrong"));
        if (passwordMatch(request.password(), user.getPassword())) {
            return constructedResponse();
        }

        return null;
    }

    private boolean passwordMatch(String password, String savedPassword) {
        return super.getApplicationConfig().passwordEncoder().matches(password, savedPassword);
    }

    private TokenResponse constructedResponse() {
        return TokenResponse.builder().token("0000").build();
    }
}
