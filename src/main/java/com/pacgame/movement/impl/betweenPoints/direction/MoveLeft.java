package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.event.MovementEventFacade;
import com.pacgame.movement.impl.betweenPoints.event.MoverBetweenPointsEventFacade;
import com.pacgame.movement.move.direction.IMoveLeft;
import com.pacgame.provider.animation.AnimationBuilder;
import com.pacgame.provider.property.PropertyProvider;

public class MoveLeft extends Move implements IMoveLeft {
    private MoverBetweenPointsEventFacade movementEventFacade;

    public MoveLeft(MovePoint2D point, AnimationBuilder animationBuilder, MoverBetweenPointsEventFacade movementEventFacade) {
        super(point, animationBuilder);
        this.movementEventFacade = movementEventFacade;
    }

    @Override
    public void move(ObjectMoving2D objectMoving) {
        animation = animationBuilder
                .addAnimateProperty(new PropertyProvider<Integer>() {
                    @Override
                    public Integer get() {
                        return objectMoving.XAxisProperty().get();
                    }

                    @Override
                    public void set(Integer val) {
                        objectMoving.XAxisProperty().set(val);
                    }
                }, point.getX())
                .setCycleCount(1)
                .notAutoReverse()
                .durationMilis(DURATION)
                .build();

        animation.play();
        movementEventFacade.emitEvent(movementEventFacade.createMoveLeftEvent(this, objectMoving.XAxisProperty().get(), objectMoving.YAxisProperty().get()));

    }
}
