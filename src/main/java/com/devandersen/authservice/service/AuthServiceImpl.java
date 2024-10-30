package com.devandersen.authservice.service;

import com.devandersen.authservice.client.UserFeignClient;
import com.devandersen.authservice.client.dtos.UserValidationResponse;
import com.devandersen.authservice.client.dtos.ValidateUserRequest;
import com.devandersen.authservice.utils.JwtUtils;
import com.devandersen.authservice.vos.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserFeignClient userFeignClient;
    private final JwtUtils jwtUtils;

    @Override
    public AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest) {
        log.info("Starting validating user {} credentials", validateUserRequest.getUsername());
        var userValidationResponse = userFeignClient.validateUser(validateUserRequest);
        if(userValidationResponse.getValid()){
            log.info("Successfully validated user {}", validateUserRequest.getUsername());
            return new AuthValidationResponse(jwtUtils.generateToken(validateUserRequest.getUsername()));
        }
        //Como retornar amigavel ao cliente isso
        log.error("Failed to validate user {}", validateUserRequest.getUsername());
        throw new RuntimeException("Token generation failed");
    }
}
