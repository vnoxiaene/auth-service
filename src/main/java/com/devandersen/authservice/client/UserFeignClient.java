package com.devandersen.authservice.client;

import com.devandersen.authservice.client.dtos.ValidateUserRequest;
import com.devandersen.authservice.client.dtos.UserValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-management-service", url = "http://localhost:8080")
public interface UserFeignClient {

    @PostMapping("/users/validate")
    UserValidationResponse validateUser(@RequestBody ValidateUserRequest validateUserRequest);

}
