package com.banking.auth_service.validation;

import com.banking.auth_service.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null || username.isEmpty()) {
            return true; // Dejamos que @NotBlank valide si está vacío
        }
        // Retorna TRUE si NO existe (es válido), FALSE si ya existe (error)
        return !userRepository.findByUsername(username).isPresent();
    }
}