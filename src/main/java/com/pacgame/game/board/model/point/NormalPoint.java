package com.pacgame.game.board.model.point;

import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.property.BaseProperty;
import com.pacgame.game.property.ValueProperty;

public class NormalPoint implements IPoint {

    private static int INITIAL_VALUE = 10;
    private BaseProperty<Integer> value;

    private void init()
    {
        value = new ValueProperty(INITIAL_VALUE);

    }

    @Override
    public int getValue() {
        return value.get();
    }

    @Override
    public void changeToEaten() {

    }

    @Override
    public void setPosition(IMapPoint position) {

    }

    @Override
    public boolean touching(BoardObject el) {
        return false;
    }
}
