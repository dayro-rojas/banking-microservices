package com.banking.auth_service.controller;

import com.banking.auth_service.dto.LoginRequest;
import com.banking.auth_service.dto.LoginResponse;
import com.banking.auth_service.entity.User;
import com.banking.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        authService.register(user);
        return ResponseEntity.ok("Usuario registrado con éxito en auth_db");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // Este endpoint servirá para que el Frontend o Postman verifiquen que el token funciona
    @GetMapping("/me")
    public ResponseEntity<?> testToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("Si puedes ver esto, tu JWT es válido y estás autenticado.");
    }
}