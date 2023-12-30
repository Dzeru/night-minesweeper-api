package com.dzeru.night_minesweeper_api.model;

public enum FieldObject {
    WALL('w'), MINE('m');

    public final char character;

    FieldObject(char character) {
        this.character = character;
    }
}
