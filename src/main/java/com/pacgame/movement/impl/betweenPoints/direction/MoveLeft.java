package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.move.direction.IMoveLeft;
import com.pacgame.provider.animation.AnimationBuilder;
import com.pacgame.provider.property.PropertyProvider;

public class MoveLeft extends Move implements IMoveLeft {
    public MoveLeft(MovePoint2D point, AnimationBuilder animationBuilder) {
        super(point, animationBuilder);
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
    }
}
