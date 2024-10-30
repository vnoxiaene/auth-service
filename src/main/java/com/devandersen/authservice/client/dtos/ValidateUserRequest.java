package com.devandersen.authservice.client.dtos;

import lombok.*;

@Value
public class ValidateUserRequest {
    String username;
    String password;
}
