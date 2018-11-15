package com.pacgame.game.board.level;

import com.pacgame.game.board.point.Point;

import java.util.Map;

public class Level {

    Map<String, Point> points;

    public Level(Map<String, Point> points) {
        this.points = points;
    }


}
