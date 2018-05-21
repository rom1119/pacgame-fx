package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RedMaze extends Maze {

    private final String mazeColor = "red";

    public RedMaze(Point2D point, int width, int height) {
        super(point, width, height);

        updateIcon();
    }

    @Override
    protected String getIconPath(int direction)
    {
        switch (direction) {
            case Direction.UP :
                return "./enemy/" + mazeColor + "/up.png";
            case Direction.DOWN :
                return "./enemy/" + mazeColor + "/down.png";
            case Direction.LEFT :
                return "./enemy/" + mazeColor + "/left.png";
            case Direction.RIGHT :
                return "./enemy/" + mazeColor + "/right.png";
            default:
                return "./enemy/" + mazeColor + "/right.png";

        }
    }

}
