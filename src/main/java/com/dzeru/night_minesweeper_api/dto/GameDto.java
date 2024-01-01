package com.dzeru.night_minesweeper_api.dto;

public record GameDto(String id,
                      int x,
                      int y,
                      boolean north,
                      boolean northEast,
                      boolean east,
                      boolean southEast,
                      boolean south,
                      boolean southWest,
                      boolean west,
                      boolean northWest,
                      boolean isAlive,
                      int minesAll,
                      int minesNearby) {}
