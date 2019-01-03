package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.move.direction.IMoveDown;
import com.pacgame.provider.animation.AnimationBuilder;
import com.pacgame.provider.property.PropertyProvider;

public class MoveDown extends Move implements IMoveDown {

    public MoveDown(MovePoint2D point, AnimationBuilder animationBuilder) {
        super(point, animationBuilder);
    }

    @Override
    public void move(ObjectMoving2D objectMoving) {
        animation = animationBuilder
                .addAnimateProperty(new PropertyProvider<Integer>() {
                    @Override
                    public Integer get() {
                        return objectMoving.YAxisProperty().get();
                    }

                    @Override
                    public void set(Integer val) {
                        objectMoving.YAxisProperty().set(val);
                    }
                }, point.getY())
                .setCycleCount(1)
                .notAutoReverse()
                .durationMilis(DURATION)
                .build();

        animation.play();
    }
}
