package com.devandersen.authservice.service;

import com.devandersen.authservice.client.dtos.ValidateUserRequest;
import com.devandersen.authservice.vos.AuthValidationResponse;

public interface AuthService {


    AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest);
}
