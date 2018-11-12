package com.pacgame.gameElement;

import com.pacgame.gameElement.standElement.BigPoint;
import com.pacgame.gameElement.standElement.SmallPoint;
import com.pacgame.provider.IShapeProvider;
import com.pacgame.provider.color.Yellow;
import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.component.shape.Rectangle;

class PointFactoryImpl implements PointFactory {

    private IShapeProvider shapeProvider;
    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int RADIUS = 5;

    public PointFactoryImpl(IShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    @Override
    public StandComponent createNormalPoint() {
        Rectangle build = shapeProvider.rectangleBuilder().with(WIDTH, HEIGHT).color(new Yellow()).build();

        return new SmallPoint(build);
    }

    @Override
    public StandComponent createBigPoint() {
        Arc arc = shapeProvider.arcBuilder().radius(RADIUS).color(new Yellow()).build();
        return new BigPoint(arc);
    }
}
