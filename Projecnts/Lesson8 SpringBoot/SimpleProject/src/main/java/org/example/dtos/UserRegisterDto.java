package org.example.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private MultipartFile image;
}
