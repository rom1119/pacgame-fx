package com.pacgame.model;

import com.pacgame.Direction;
import javafx.application.Platform;
import javafx.geometry.Point2D;

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

    protected void updatePosition()
    {
        Platform.runLater(new Runnable() {
            public void run() {
                collider.setTranslateX(point.getX());
                collider.setTranslateY(point.getY() - getHeight() / 2);

                collider.setLayoutX(-(getWidth() / 2 ));
                collider.setLayoutY(-(getWidth() / 2 ));
                icon.setLayoutX(-(getWidth() / 2));
                icon.setLayoutY(-(getWidth() / 2 ));

                icon.setTranslateX(point.getX());
                icon.setTranslateY(point.getY() - getHeight() / 2);
            }
        });
    }

    @Override
    public void moveLeft(int step) {

        int x = 0;
        x = x + step;


        point = point.subtract(x, 0);
        updatePosition();
    }

    @Override
    public void moveRight(int step) {

        int x = 0;
        x = x + step;

        point = point.add(x, 0);
        updatePosition();
    }

    @Override
    public void moveUp(int step) {
        int y = 0;
        y = y + step;

        point = point.subtract(0, y);
        updatePosition();
    }


    @Override
    public void moveDown(int step) {

        int y = 0;
        y = y + step;

        point = point.add(0, y);
        updatePosition();


    }

}
