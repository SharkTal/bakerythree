package com.example.bakerythree.service;

import com.example.bakerythree.domain.User;
import com.example.bakerythree.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
