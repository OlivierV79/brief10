package fr.simplon2024.forknow.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;

import fr.simplon2024.forknow.dto.RegisterDto;
import fr.simplon2024.forknow.dto.UserDto;
import fr.simplon2024.forknow.model.User;

public interface UserService {
    void saveUser(UserDto user);
    void saveUser(RegisterDto userMapping);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> from(Authentication authentication);
}
