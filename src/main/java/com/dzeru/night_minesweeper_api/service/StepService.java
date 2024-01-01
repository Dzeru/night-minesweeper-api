package com.dzeru.night_minesweeper_api.service;

import com.dzeru.night_minesweeper_api.generator.FieldGenerator;
import com.dzeru.night_minesweeper_api.model.Direction;
import com.dzeru.night_minesweeper_api.model.Field;
import com.dzeru.night_minesweeper_api.model.FieldObject;
import com.dzeru.night_minesweeper_api.model.Game;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.dzeru.night_minesweeper_api.model.FieldObject.isMine;

@Service
public class StepService {

    private final FieldGenerator fieldGenerator;

    public StepService(FieldGenerator fieldGenerator) {
        this.fieldGenerator = fieldGenerator;
    }

    public Game step(Direction direction, boolean isMine) {
        var game = getGame();
        var field = game.field();
        var minesAll = game.minesAll();

        var newX = getX(game.x(), direction);
        var newY = getY(game.y(), direction);

        if (isMine(field[newX][newY]) && !isMine) {
            return new Game(game.id(), field, newX, newY, minesAll, false);
        }

        if (isMine(field[newX][newY]) && isMine) {
            field[newX][newY] = FieldObject.EMPTY.character;
            return new Game(game.id(), field, newX, newY, minesAll - 1, true);
        }

        return new Game(game.id(), field, newX, newY, minesAll, true);
    }

    private Game getGame() {
        var field = fieldGenerator.generateField(7, 7);
        return new Game(UUID.randomUUID().toString(), field.field(), 1, 2, field.minesAll(), true);
    }

    private int getX(int x, Direction direction) {
        if (direction.equals(Direction.NORTH) || direction.equals(Direction.NORTH_EAST) || direction.equals(Direction.NORTH_WEST)) {
            return x + 1;
        }

        if (direction.equals(Direction.SOUTH) || direction.equals(Direction.SOUTH_EAST) || direction.equals(Direction.SOUTH_WEST)) {
            return x - 1;
        }

        return x;
    }

    private int getY(int y, Direction direction) {
        if (direction.equals(Direction.WEST) || direction.equals(Direction.SOUTH_WEST) || direction.equals(Direction.NORTH_WEST)) {
            return y + 1;
        }

        if (direction.equals(Direction.EAST) || direction.equals(Direction.SOUTH_EAST) || direction.equals(Direction.NORTH_EAST)) {
            return y - 1;
        }

        return y;
    }
}
