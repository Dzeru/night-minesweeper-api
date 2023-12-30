package com.dzeru.night_minesweeper_api.dto;

public record GameDto(boolean north,
                      boolean south,
                      boolean west,
                      boolean east,
                      boolean isAlive,
                      int minesAll,
                      int minesNearby) {}
