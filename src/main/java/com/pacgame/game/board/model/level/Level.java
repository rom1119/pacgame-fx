package com.pacgame.game.board.model.level;

import com.pacgame.game.board.model.point.Point;

import java.util.Map;

public class Level {

    Map<String, Point> points;

    public Level(Map<String, Point> points) {
        this.points = points;
    }


}
