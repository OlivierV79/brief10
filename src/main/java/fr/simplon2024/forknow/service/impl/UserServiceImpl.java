package fr.simplon2024.forknow.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.simplon2024.forknow.dto.RegisterDto;
import fr.simplon2024.forknow.dto.UserDto;
import fr.simplon2024.forknow.model.User;
import fr.simplon2024.forknow.model.UserRole;
import fr.simplon2024.forknow.repository.UserRepository;
import fr.simplon2024.forknow.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto user) {
        User userEntity = User.builder()
            .username(user.getUsername())
            .password(passwordEncoder.encode(user.getPassword()))
            .role(UserRole.USER)
            .build();
        userRepository.save(userEntity);
    }
    
    @Override
    public void saveUser(RegisterDto user) {
        User userEntity = User.builder()
            .username(user.getUsername())
            .email(user.getEmail())
            .password(passwordEncoder.encode(user.getPassword()))
            .role(UserRole.USER)
            .creation_date(java.sql.Timestamp.valueOf(LocalDateTime.now()))
            .build();
        userRepository.save(userEntity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> from(Authentication authentication) {
        if(authentication == null){
            return Optional.empty();
        }
        
        Object principal = authentication.getPrincipal();
        if(!(principal instanceof UserDetails)){
            return Optional.empty();
        }

        UserDetails userDetails = (UserDetails)principal;
        return userRepository.findByUsername(userDetails.getUsername());
    }
    
}
