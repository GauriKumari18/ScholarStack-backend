package com.gaurikumari.marketplace.service.impl;

import com.gaurikumari.marketplace.dto.Request.RegisterRequest;
import com.gaurikumari.marketplace.dto.Response.UserResponse;
import com.gaurikumari.marketplace.model.User;
import com.gaurikumari.marketplace.repository.UserRepository;
import com.gaurikumari.marketplace.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse registerUser(RegisterRequest request) {

        // 1. Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered: " + request.getEmail());
        }

        // 2. Convert DTO → Entity
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCollegeName(request.getCollegeName());
        user.setBio(request.getBio());
        user.setRole(request.getRole());

        // 3. Save user
        User savedUser = userRepository.save(user);

        // 4. Convert Entity → Response DTO
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setCollegeName(user.getCollegeName());
        response.setBio(user.getBio());
        response.setRating(user.getRating());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }

}