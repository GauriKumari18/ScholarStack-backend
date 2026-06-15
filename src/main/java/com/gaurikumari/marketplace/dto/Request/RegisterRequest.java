package com.gaurikumari.marketplace.dto.Request;

import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String fullName;

    private String email;

    private String password;

    private String collegeName;

    private String bio;

    private Role role;

}