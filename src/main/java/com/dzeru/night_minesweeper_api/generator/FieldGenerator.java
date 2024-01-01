package com.dzeru.night_minesweeper_api.generator;

import com.dzeru.night_minesweeper_api.model.Field;
import com.dzeru.night_minesweeper_api.model.FieldObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class FieldGenerator {

    private final Random random = new Random();

    public Field generateField(int horizontal, int vertical) {
        var field = new char[horizontal + 2][vertical + 2]; // + 2 for walls

        for (var row : field) {
            Arrays.fill(row, FieldObject.EMPTY.character);
        }

        field = generateWalls(field);

        var minesCount = generateMinesCount(horizontal, vertical);

        field = generateMines(field, minesCount);

        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                System.out.print(field[i][k]);
            }
            System.out.println();
        }

        return new Field(field, minesCount);
    }

    private int generateMinesCount(int horizontal, int vertical) {
        var min = Math.min(horizontal, vertical);
        return min + random.nextInt(min);
    }

    private char[][] generateWalls(char[][] field) {
        for (int i = 0; i < field[0].length; i++) {
            field[0][i] = FieldObject.WALL.character;
            field[field.length - 1][i] = FieldObject.WALL.character;
            field[i][0] = FieldObject.WALL.character;
            field[i][field[i].length - 1] = FieldObject.WALL.character;
        }

        field[2][2] = FieldObject.WALL.character;
        return field;
    }

    private char[][] generateMines(char[][] field, int minesCount) {
        field[3][2] = FieldObject.MINE.character;
        return field;
    }
}
