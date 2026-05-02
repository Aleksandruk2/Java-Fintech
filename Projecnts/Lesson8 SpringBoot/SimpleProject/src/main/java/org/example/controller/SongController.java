package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SongController {
    private final SongService service;

    @GetMapping("/songs")
    public String index(Model model) {
        model.addAttribute("songs", service.getAll());
        return "songs/index";
    }
}
