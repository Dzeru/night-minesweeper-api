package com.dzeru.night_minesweeper_api.controller;

import com.dzeru.night_minesweeper_api.dto.GameDto;
import com.dzeru.night_minesweeper_api.mapper.HttpMapper;
import com.dzeru.night_minesweeper_api.model.Direction;
import com.dzeru.night_minesweeper_api.service.StartService;
import com.dzeru.night_minesweeper_api.service.StepService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final StartService startService;
    private final StepService stepService;
    private final HttpMapper httpMapper;

    public GameController(StartService startService,
                          StepService stepService,
                          HttpMapper httpMapper) {
        this.startService = startService;
        this.stepService = stepService;
        this.httpMapper = httpMapper;
    }

    @PostMapping("/start")
    public GameDto start(@RequestParam("horizontal") int horizontal,
                         @RequestParam("vertical") int vertical) {
        return httpMapper.toDto(startService.startGame(horizontal, vertical));
    }

    @PostMapping("/step")
    public GameDto step(@RequestParam("direction") Direction direction,
                        @RequestParam("isMine") boolean isMine) {
        return httpMapper.toDto(stepService.step(direction, isMine));
    }
}
