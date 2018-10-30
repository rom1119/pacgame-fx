package com.pacgame.board.model;

import com.pacgame.Direction;
import com.pacgame.board.event.MazeEvent;
import com.pacgame.board.event.eventHandler.OnPacmanTouchMaze;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Maze extends Player implements Eatable {

    protected int value = 10;
    protected final String mazeColor = "blue";
    protected boolean eatable = false;
    protected boolean isGhost = false;

    public Maze( Point2D point, int width, int height) {
        super();
        this.point = point;
        setWidth(width);
        setHeight(height);
        setName("Maze");

        this.collider = new Rectangle(getWidth(), getHeight());
        collider.setFill(Color.TRANSPARENT);

        this.icon = new Rectangle(getWidth(), getHeight());
        Image img = new Image("./enemy/" + mazeColor + "/main.png");
        this.icon.setFill(new ImagePattern(img));

        initPosition();

        turnUp();

        setCheckedDirection(Direction.LEFT);

        getCollider().addEventHandler(MazeEvent.TOUCH, new OnPacmanTouchMaze());

    }

    protected abstract String getIconPath(int direction);

    protected String getGhostIconPath(int direction)
    {
        switch (direction) {
            case Direction.UP :
                return "./enemy/ghost/up.png";
            case Direction.DOWN :
                return "./enemy/ghost/down.png";
            case Direction.LEFT :
                return "./enemy/ghost/left.png";
            case Direction.RIGHT :
                return "./enemy/ghost/right.png";
            default:
                return "./enemy/ghost/right.png";

        }
    }

    public void updateIcon()
    {
        Image img;
        if (isGhost()) {
            img = new Image(getGhostIconPath(this.getCheckedDirection()));
        } else {
            img = new Image(getIconPath(this.getCheckedDirection()));
        }
        this.getIcon().setFill(new ImagePattern(img));
    }

    @Override
    public void initPosition() {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY() - getHeight() / 2);

        collider.setLayoutX(-(getWidth() / 3));
        collider.setLayoutY(-(getWidth() / 2));
        icon.setLayoutX(-(getWidth() / 3));
        icon.setLayoutY(-(getWidth() / 2));

        icon.setTranslateX(point.getX());
        icon.setTranslateY(point.getY() - getHeight() / 2);

    }

    @Override
    public void turnLeft() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    @Override
    public void turnRight() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    @Override
    public void turnUp() {
        if (!this.isEatable()) {
            updateIcon();
        }

    }

    @Override
    public void turnDown() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean isEatable()
    {
        return eatable;
    }

    @Override
    public void setEatable(boolean isEatable)
    {
        this.eatable = isEatable;
    }

    public boolean isGhost() {
        return isGhost;
    }

    public void setGhost(boolean ghost) {
        isGhost = ghost;
    }
}
