package com.taruna.wahyudi.app.component.service.transaction;

import com.taruna.wahyudi.app.component.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public sealed class UserServiceTransaction extends ApplicationService permits UserServiceSaver {
}
