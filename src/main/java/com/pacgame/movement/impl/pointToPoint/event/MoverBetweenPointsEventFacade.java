package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.event.MoveEventHandler;
import com.pacgame.movement.event.MovementEventFacade;
import com.pacgame.movement.impl.pointToPoint.direction.*;

public class MoverBetweenPointsEventFacade implements MovementEventFacade<BaseMoveEventBetweenPoints> {

    private EventDispatcher eventDispatcher;

    public MoverBetweenPointsEventFacade() {
        eventDispatcher = new EventDispatcher();
    }

    @Override
    public <S extends BaseMoveEventBetweenPoints> void addEventHandler(S event, MoveEventHandler<? super S> eventHandler) {
        eventDispatcher.addHandler(event, eventHandler);
    }

    @Override
    public <S extends BaseMoveEventBetweenPoints> void removeEventHandler(S event, MoveEventHandler<? super S> eventHandler) {
        throw new RuntimeException("Method not implemented");
    }

    @Override
    public <S extends BaseMoveEventBetweenPoints> void emitEvent(S event) {
        eventDispatcher.dispatchEvent(event);
    }

    public MoveUpEvent createMoveUpEvent(MoveUp moveDown, int fromX, int fromY) {
        return new MoveUpEvent(moveDown, fromX, fromY);
    }

    public MoveDownEvent createMoveDownEvent(MoveDown moveDown, int fromX, int fromY) {
        return new MoveDownEvent(moveDown, fromX, fromY);
    }

    public MoveLeftEvent createMoveLeftEvent(MoveLeft moveDown, int fromX, int fromY) {
        return new MoveLeftEvent(moveDown, fromX, fromY);
    }

    public MoveRightEvent createMoveRightEvent(MoveRight moveDown, int fromX, int fromY) {
        return new MoveRightEvent(moveDown, fromX, fromY);
    }

    public AnyMoveEndEvent createAnyMoveEndEvent(Move moveDown) {
        return new AnyMoveEndEvent(moveDown);
    }

    public MoveUpEvent onMoveUpEvent() {
        return new MoveUpEvent();
    }

    public MoveDownEvent onMoveDownEvent() {
        return new MoveDownEvent();
    }

    public MoveLeftEvent onMoveLeftEvent() {
        return new MoveLeftEvent();
    }

    public MoveRightEvent onMoveRightEvent() {
        return new MoveRightEvent();
    }

    public AnyMoveEndEvent onAnyMoveEndEvent() {
        return new AnyMoveEndEvent();
    }
}
