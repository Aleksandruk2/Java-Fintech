package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dtos.GenreDto;
import org.example.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final GenreService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("genres", service.getAll());
        return "index";
    }

    @GetMapping("/genres/create")
    public String createForm(Model model) {
        model.addAttribute("genre", new GenreDto());
        return "genre-create";
    }

    @PostMapping("/genres/create")
    public String create(@ModelAttribute GenreDto dto, Model model) {
        try {
            service.create(dto);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("genre", dto);
            return "genre-create";
        }
    }
}
