package com.dzeru.night_minesweeper_api.service;

import com.dzeru.night_minesweeper_api.generator.FieldGenerator;
import com.dzeru.night_minesweeper_api.model.Game;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StartService {

    private final FieldGenerator fieldGenerator;

    public StartService(FieldGenerator fieldGenerator) {
        this.fieldGenerator = fieldGenerator;
    }

    public Game startGame(int horizontal, int vertical) {
        var field = fieldGenerator.generateField(horizontal, vertical);
        return new Game(UUID.randomUUID().toString(), field.field(), 1, 2, field.minesAll(), true);
    }
}
