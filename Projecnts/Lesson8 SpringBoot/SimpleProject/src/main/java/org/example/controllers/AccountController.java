package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.example.dtos.UserRegisterDto;
import org.example.services.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AccountController {
    private final UserInfoService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegisterDto());
        return "account/register/index";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") UserRegisterDto dto, Model model,
                               HttpServletRequest request) {
        try {
            userService.register(dto);
            request.login(dto.getUsername(), dto.getPassword());
            return "redirect:/";
        }
        catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "account/register/index";
        }
    }
}
