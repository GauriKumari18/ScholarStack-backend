package com.gaurikumari.marketplace.dto.Response;

import com.gaurikumari.marketplace.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String fullName;

    private String email;

    private String collegeName;

    private String bio;

    private Double rating;

    private UserRole role;

    private LocalDateTime createdAt;

}