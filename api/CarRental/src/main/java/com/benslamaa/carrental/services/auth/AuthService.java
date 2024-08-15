package com.benslamaa.carrental.services.auth;

import com.benslamaa.carrental.dto.SignupRequest;
import com.benslamaa.carrental.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerwithEmail(String email);
}
