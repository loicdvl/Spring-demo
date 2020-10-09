package com.loicdev.springdemo.payload;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}