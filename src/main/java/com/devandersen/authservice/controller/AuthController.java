package com.devandersen.authservice.controller;


import com.devandersen.authservice.client.dtos.ValidateUserRequest;
import com.devandersen.authservice.service.AuthService;
import com.devandersen.authservice.vos.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    ResponseEntity<AuthValidationResponse> generateToken(@RequestBody ValidateUserRequest validateUserRequest){
        log.info("Received request to generate token: {}", validateUserRequest);
        return ResponseEntity.ok(authService.generateToken(validateUserRequest));
    }


}
