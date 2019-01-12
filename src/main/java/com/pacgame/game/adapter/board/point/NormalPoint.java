package com.pacgame.game.adapter.board.point;

import com.pacgame.game.adapter.board.GameElement;
import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.gameElement.standElement.SmallPoint;

public class NormalPoint extends GameElement implements IPoint {

    private static int INITIAL_VALUE = 10;
    private int value;

    private com.pacgame.gameElement.standElement.SmallPoint providedObject;

    public NormalPoint(SmallPoint providedObject) {
        this.providedObject = providedObject;
        value = INITIAL_VALUE;
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
    public boolean touching(BoardObject el) {
        return providedObject.touching(((GameElement) el).getProvidedObject());
    }

    @Override
    public com.pacgame.gameElement.GameElement getProvidedObject() {
        return providedObject;
    }
}
