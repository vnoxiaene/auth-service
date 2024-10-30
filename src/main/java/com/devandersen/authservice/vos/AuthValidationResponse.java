package com.devandersen.authservice.vos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthValidationResponse {
    private String token;
}
