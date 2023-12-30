package com.dzeru.night_minesweeper_api.controller;

import com.dzeru.night_minesweeper_api.dto.GameDto;
import com.dzeru.night_minesweeper_api.mapper.HttpMapper;
import com.dzeru.night_minesweeper_api.service.StartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final StartService startService;
    private final HttpMapper httpMapper;

    public GameController(StartService startService, HttpMapper httpMapper) {
        this.startService = startService;
        this.httpMapper = httpMapper;
    }

    @PostMapping("/start")
    public GameDto start(@RequestParam("horizontal") int horizontal,
                         @RequestParam("vertical") int vertical) {
        return httpMapper.toDto(startService.startGame(horizontal, vertical));
    }
}
