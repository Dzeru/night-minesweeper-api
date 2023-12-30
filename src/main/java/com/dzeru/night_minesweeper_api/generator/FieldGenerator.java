package com.dzeru.night_minesweeper_api.generator;

import com.dzeru.night_minesweeper_api.model.Field;
import com.dzeru.night_minesweeper_api.model.FieldObject;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FieldGenerator {

    private final Random random = new Random();

    public Field generateField(int horizontal, int vertical) {
        var field = new char[horizontal][vertical];

        field = generateWalls(field);

        var minesCount = generateMinesCount(horizontal, vertical);

        field = generateMines(field, minesCount);

        return new Field(field, minesCount);
    }

    private int generateMinesCount(int horizontal, int vertical) {
        var min = Math.min(horizontal, vertical);
        return min + random.nextInt(min);
    }

    private char[][] generateWalls(char[][] field) {
        field[1][2] = FieldObject.WALL.character;
        return field;
    }

    private char[][] generateMines(char[][] field, int minesCount) {
        field[1][1] = FieldObject.MINE.character;
        return field;
    }
}
