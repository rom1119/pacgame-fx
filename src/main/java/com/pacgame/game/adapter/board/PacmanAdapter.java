package com.pacgame.game.adapter.board;

import com.pacgame.View;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.exception.EatYourSelfException;
import com.pacgame.gameElement.movingElement.Pacman;

public class PacmanAdapter extends ViewAdapter implements IPacman {

    private Pacman providedObject;

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
    public void setPosition(IMapPoint pacmanInitPosition) {
        providedObject.setX(pacmanInitPosition.getX());
        providedObject.setY(pacmanInitPosition.getY());
    }

    @Override
    public View getProvidedObject() {
        return providedObject;
    }
}
