package com.pacgame.game.adapter.board.movement.rules;

import com.pacgame.game.adapter.board.movement.MovePoint2DAdapter;
import com.pacgame.movement.MovePoint;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.MoveRule;

public class DoorCloseRule implements MoveRule {
    @Override
    public boolean isSatisfied(MovePoint point) {
        return !((MovePoint2DAdapter) point).isDoor();
    }
}
