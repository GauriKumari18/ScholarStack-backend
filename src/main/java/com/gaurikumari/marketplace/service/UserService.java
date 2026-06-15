package com.gaurikumari.marketplace.service;

import com.gaurikumari.marketplace.dto.Request.RegisterRequest;
import com.gaurikumari.marketplace.dto.Response.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterRequest request);

}