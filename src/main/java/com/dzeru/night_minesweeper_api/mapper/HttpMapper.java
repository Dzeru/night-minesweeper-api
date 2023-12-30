package com.dzeru.night_minesweeper_api.mapper;

import com.dzeru.night_minesweeper_api.dto.GameDto;
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
                if (field[i][k] == 'w') {
                    minesNearby++;
                }
            }
        }

        // TODO directions

        return new GameDto(true, true, true, true, game.isAlive(), game.minesAll(), minesNearby);
    }
}
