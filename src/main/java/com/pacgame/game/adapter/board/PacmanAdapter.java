package com.pacgame.game.adapter.board;

import com.pacgame.event.EventFacade;
import com.pacgame.event.listener.ChangeListener;
import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.exception.EatYourSelfException;
import com.pacgame.gameElement.movingElement.Pacman;
import com.pacgame.movement.impl.pointToPoint.event.MoverBetweenPointsEventFacade;

public class PacmanAdapter extends GameElement implements IPacman {

    private Pacman providedObject;
    private EventFacade eventFacade;
    private IMovement movement;
    private BoardEventFacade boardEventFacade;

    public PacmanAdapter(Pacman providedObject, EventFacade eventFacade) {
        this.providedObject = providedObject;
        this.eventFacade = eventFacade;
    }

    @Override
    public void addScore(int score) {
        providedObject.addScore(score);
    }

    @Override
    public void eat(Eatable eatableEl) throws EatYourSelfException {

    }

    @Override
    public void setBoardEventFacade(BoardEventFacade boardEventFacade) {
        this.boardEventFacade = boardEventFacade;
        onMove();
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
    public void moveUp() {
        movement.moveUp();
    }

    @Override
    public void moveDown() {
        movement.moveDown();
    }

    @Override
    public void moveLeft() {
        movement.moveLeft();
    }

    @Override
    public void moveRight() {
        movement.moveRight();

    }

    public void onMove() {

        PacmanAdapter pacmanAdapter = this;
        getProvidedObject().XProperty().setOnChangeProperty(new ChangeListener() {
            @Override
            public void onChange(Object oldVal, Object newVal) {
                boardEventFacade.emitEvent(boardEventFacade.createPacmanMove(pacmanAdapter, pacmanAdapter, getX(), getY()));
            }
        });

        getProvidedObject().YProperty().setOnChangeProperty(new ChangeListener() {
            @Override
            public void onChange(Object oldVal, Object newVal) {
                boardEventFacade.emitEvent(boardEventFacade.createPacmanMove(pacmanAdapter, pacmanAdapter, getX(), getY()));
            }
        });
    }

    @Override
    public void initMovementSystem(IMovement movement) {
        this.movement = movement;
    }

    public void onMoveDirectionChange(MoverBetweenPointsEventFacade movementEventFacade) {

        movementEventFacade.addEventHandler(movementEventFacade.onMoveUpEvent(), event -> {
            providedObject.turnUp();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveLeftEvent(), event -> {
            providedObject.turnLeft();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveDownEvent(), event -> {
            providedObject.turnDown();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveRightEvent(), event -> {
            providedObject.turnRight();

        });
    }

    @Override
    public boolean touching(BoardObject el) {
        return getProvidedObject().touching(((GameElement) el).getProvidedObject());
    }
}
