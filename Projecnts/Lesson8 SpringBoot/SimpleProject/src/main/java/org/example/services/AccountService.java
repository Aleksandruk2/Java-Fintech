package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dtos.UserRegisterDto;
import org.example.entities.RoleEntity;
import org.example.entities.UserEntity;
import org.example.repositories.IUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import org.example.data.constants.RolesConstants;
import org.example.repositories.IRoleRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity register(UserRegisterDto dto, HttpServletRequest request) {
        UserEntity user = new UserEntity();

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

       if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            try {
                String fileName = UUID.randomUUID()
                        .toString()
                        .substring(0, 12) + "_" +
                        dto.getImage().getOriginalFilename().replace(" ", "_");
                new SaveUserImageService().saveUserImage(dto.getImage(), fileName);
                user.setImage(fileName);
            } catch (Exception e) {
                throw new RuntimeException("Failed to save user image", e);
            }
        }

        RoleEntity roleUser = roleRepository.findByName(RolesConstants.UserRole).orElseThrow(()->new RuntimeException("User role not found"));
        user.getRoles().add(roleUser);

        UserEntity savedUser = userRepository.save(user);

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(savedUser, null, savedUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        request.getSession(true).setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );


        return savedUser;
    }
}
