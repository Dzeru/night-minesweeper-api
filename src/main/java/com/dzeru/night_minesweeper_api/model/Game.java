package com.dzeru.night_minesweeper_api.model;

public record Game(String id,
                   char[][] field,
                   int x,
                   int y,
                   int minesAll,
                   boolean isAlive) {}