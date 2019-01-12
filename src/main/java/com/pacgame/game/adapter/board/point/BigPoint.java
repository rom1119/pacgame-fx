package com.pacgame.game.adapter.board.point;

import com.pacgame.game.adapter.board.GameElement;
import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.point.IPoint;

public class BigPoint extends GameElement implements IPoint {

    private static int INITIAL_VALUE = 20;
    private int value;


    private com.pacgame.gameElement.standElement.BigPoint providedObject;

    public BigPoint(com.pacgame.gameElement.standElement.BigPoint providedObject) {
        this.providedObject = providedObject;
        value = INITIAL_VALUE;

    }

    @Override
    public boolean touching(BoardObject el) {
        return providedObject.touching(((GameElement) el).getProvidedObject());
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void changeToEaten() {
        providedObject.hide();
    }

    @Override
    public void setPosition(IMapPoint initPosition) {

    }

    @Override
    public com.pacgame.gameElement.GameElement getProvidedObject() {
        return providedObject;
    }
}
