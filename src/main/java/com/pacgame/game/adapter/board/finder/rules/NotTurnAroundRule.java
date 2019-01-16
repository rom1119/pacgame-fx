package com.pacgame.game.adapter.board.finder.rules;

import com.pacgame.finder.FindPoint;
import com.pacgame.finder.FindPoint3D;
import com.pacgame.finder.FinderRule;
import com.pacgame.game.adapter.ValueObject;
import com.pacgame.game.adapter.board.finder.FindPoint2DAdapter;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.level.IMapPoint;

public class NotTurnAroundRule implements FinderRule {

    private ValueObject<IMapPoint> objectWithPosition;

    public NotTurnAroundRule(ValueObject<IMapPoint> objectWithPosition) {
        this.objectWithPosition = objectWithPosition;
    }

    @Override
    public boolean isSatisfied(FindPoint point) {
        return point.getX() == objectWithPosition.getOldValue().getX() && point.getY() == objectWithPosition.getOldValue().getY() ? false : true;
    }
}
