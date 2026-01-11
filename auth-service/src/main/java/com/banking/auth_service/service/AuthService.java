package com.banking.auth_service.service;

import com.banking.auth_service.dto.LoginRequest;
import com.banking.auth_service.dto.LoginResponse;
import com.banking.auth_service.entity.User;

public interface AuthService {
    User register(User user);
    LoginResponse login(LoginRequest request);
}