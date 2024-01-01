package com.dzeru.night_minesweeper_api.model;

public enum FieldObject {
    EMPTY('e'), WALL('w'), MINE('m');

    public final char character;

    FieldObject(char character) {
        this.character = character;
    }

    public static boolean isWall(char cell) {
        return cell == FieldObject.WALL.character;
    }

    public static boolean isMine(char cell) {
        return cell == FieldObject.MINE.character;
    }
}
