package com.benslamaa.carrental.services.auth;

import com.benslamaa.carrental.dto.SignupRequest;
import com.benslamaa.carrental.dto.UserDto;
import com.benslamaa.carrental.entity.User;
import com.benslamaa.carrental.enums.UserRole;
import com.benslamaa.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;


    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasCustomerwithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
