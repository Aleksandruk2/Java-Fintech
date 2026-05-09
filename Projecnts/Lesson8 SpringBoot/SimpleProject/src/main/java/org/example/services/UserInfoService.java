package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.data.constants.RolesConstants;
import org.example.dtos.UserRegisterDto;
import org.example.entities.RoleEntity;
import org.example.entities.UserEntity;
import org.example.repositories.IRoleRepository;
import org.example.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${images.dir}")
    private String imagesDir;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void register(UserRegisterDto dto) throws IOException {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new IllegalArgumentException("Паролі не співпадають");
        }

        String fileName = null;

        if(!dto.getImage().isEmpty()) {
            fileName = UUID.randomUUID()
                    .toString()
                    .substring(0, 12) + "_" +
                    dto.getImage().getOriginalFilename();

            Path path = Paths.get(imagesDir + "/" + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(dto.getImage().getInputStream(), path);
        }

        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setImage(fileName);

        RoleEntity userRole = roleRepository
                .findByName(RolesConstants.UserRole)
                .orElseThrow();

        user.getRoles().add(userRole);
        userRepository.save(user);
    }
}
