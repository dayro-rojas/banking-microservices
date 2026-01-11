package com.banking.auth_service.service;

import com.banking.auth_service.dto.LoginRequest;
import com.banking.auth_service.dto.LoginResponse;
import com.banking.auth_service.entity.User;
import com.banking.auth_service.exception.AuthException;
import com.banking.auth_service.repository.UserRepository;
import com.banking.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User register(User user) {
        // 1. Validar si el nombre de usuario ya existe
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new AuthException("El nombre de usuario '" + user.getUsername() + "' ya está registrado.");
        }

        // 2. Encriptar contraseña y configurar valores por defecto
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("USER");

        // 3. Guardar en la base de datos
        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AuthException("El usuario '" + request.getUsername() + "' no existe"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthException("La contraseña ingresada es incorrecta");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token, user.getUsername());
    }
}