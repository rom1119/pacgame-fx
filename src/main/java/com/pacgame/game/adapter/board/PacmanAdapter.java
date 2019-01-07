package com.pacgame.game.adapter.board;

import com.pacgame.View;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.exception.EatYourSelfException;
import com.pacgame.gameElement.movingElement.Pacman;

public class PacmanAdapter extends ViewAdapter implements IPacman {

    private Pacman providedObject;
    private IMovement movement;

    public PacmanAdapter(Pacman providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public void addScore(int score) {
        providedObject.addScore(score);
    }

    @Override
    public void eat(Eatable eatableEl) throws EatYourSelfException {

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
    public Pacman getProvidedObject() {
        return providedObject;
    }

    @Override
    public void startMove() {
        providedObject.playEatAnimation();
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
