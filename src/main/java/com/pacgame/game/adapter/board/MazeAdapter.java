package com.pacgame.game.adapter.board;

import com.pacgame.View;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.gameElement.movingElement.Maze;

public class MazeAdapter extends ViewAdapter implements IMaze {

    private Maze providedObject;
    private IMovement movement;


    public MazeAdapter(Maze providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public int getValue() {
        return providedObject.getValue();
    }

    @Override
    public void changeToEaten() {

    }

    @Override
    public void setPosition(IMapPoint position) {
        providedObject.setX(position.getX());
        providedObject.setY(position.getY());
        if (movement !=  null) {
            movement.skipTo(position);
        }
    }

    @Override
    public void changeToNormalCharacter() {

    }

    @Override
    public View getProvidedObject() {
        return providedObject;
    }

    @Override
    public void startMove() {
        if (movement != null) {
            movement.start();

        }
    }

    @Override
    public void stopMove() {
        if (movement != null) {
            movement.stop();

        }
    }

    @Override
    public void turnUp() {
        providedObject.turnUp();
        movement.moveUp();
    }

    @Override
    public void turnDown() {
        providedObject.turnDown();
        movement.moveDown();
    }

    @Override
    public void turnLeft() {
        providedObject.turnLeft();
        movement.moveLeft();
    }

    @Override
    public void turnRight() {
        providedObject.turnRight();
        movement.moveRight();

    }

    @Override
    public void initMovementSystem(IMovement movement) {
        this.movement = movement;
    }
}
