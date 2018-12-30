package com.pacgame.gameElement;

import com.pacgame.gameElement.standElement.BigPoint;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.gameElement.standElement.SmallPoint;
import com.pacgame.provider.ShapeProvider;
import com.pacgame.provider.color.Yellow;
import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.component.shape.Rectangle;

class PointFactoryImpl implements PointFactory {

    private ShapeProvider shapeProvider;
    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int RADIUS = 5;

    public PointFactoryImpl(ShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    @Override
    public GamePoint createNormalPoint() {
        Rectangle rectangle = shapeProvider.rectangleBuilder().with(WIDTH, HEIGHT).color(new Yellow()).build();

        return new SmallPoint(rectangle);
    }

    @Override
    public GamePoint createBigPoint() {
        Arc arc = shapeProvider.arcBuilder().radius(RADIUS).color(new Yellow()).build();
        return new BigPoint(arc);
    }
}
