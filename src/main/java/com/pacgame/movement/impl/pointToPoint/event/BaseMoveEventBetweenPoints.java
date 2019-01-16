package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.event.MoveEvent;

abstract class BaseMoveEventBetweenPoints implements MoveEvent
{

    private Object source;

    public BaseMoveEventBetweenPoints(Object source) {
        this.source = source;

    }

    public BaseMoveEventBetweenPoints() {

    }

    public abstract String getName();


    public Object getSource() {
        return source;
    }


}
