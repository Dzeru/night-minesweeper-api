package com.dzeru.night_minesweeper_api.mapper;

import com.dzeru.night_minesweeper_api.dto.GameDto;
import com.dzeru.night_minesweeper_api.model.FieldObject;
import com.dzeru.night_minesweeper_api.model.Game;
import org.springframework.stereotype.Component;

@Component
public class HttpMapper {
    public GameDto toDto(Game game) {
        var field = game.field();
        var x= game.x();
        var y = game.y();

        var minesNearby = 0;

        for (var i = Math.max(0, x - 1); i <= Math.min(field.length, x + 1); i++) {
            for (var k = Math.max(0, y - 1); k <= Math.min(field[i].length, y + 1); k++) {
                if (isMine(field[i][k])) {
                    minesNearby++;
                }
            }
        }

        var north = true;
        var northEast = true;
        var east = true;
        var southEast = true;
        var south = true;
        var southWest = true;
        var west = true;
        var northWest = true;

        if (isWall(field[Math.max(0, x - 1)][y])) {
            north = false;
        }

        if (isWall(field[Math.max(0, x - 1)][Math.min(y + 1, field[x].length)])) {
            northEast = false;
        }

        if (isWall(field[x][Math.min(y + 1, field[x].length)])) {
            east = false;
        }

        if (isWall(field[Math.min(x + 1, field.length)][Math.min(y + 1, field[x].length)])) {
            southEast = false;
        }

        if (isWall(field[Math.min(x + 1, field.length)][y])) {
            south = false;
        }

        if (isWall(field[Math.min(x + 1, field.length)][Math.max(0, y - 1)])) {
            southWest = false;
        }

        if (isWall(field[x][Math.max(0, y - 1)])) {
            west = false;
        }

        if (isWall(field[Math.max(0, x - 1)][Math.max(0, y - 1)])) {
            northWest = false;
        }

        return new GameDto(x, y, north, northEast, east, southEast, south, southWest, west, northWest, game.isAlive(), game.minesAll(), minesNearby);
    }

    private boolean isWall(char cell) {
        return cell == FieldObject.WALL.character;
    }

    private boolean isMine(char cell) {
        return cell == FieldObject.MINE.character;
    }
}
