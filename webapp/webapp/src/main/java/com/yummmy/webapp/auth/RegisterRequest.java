package com.yummmy.webapp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    private String surname;
    private String name;
    private String email;
    private String password;
    private String phone;
    private boolean restaurateur;
}
