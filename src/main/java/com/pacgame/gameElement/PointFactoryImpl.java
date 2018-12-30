package com.pacgame.gameElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.gameElement.standElement.BigPoint;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.gameElement.standElement.SmallPoint;
import com.pacgame.provider.ShapeProvider;
import com.pacgame.provider.color.Red;
import com.pacgame.provider.color.Yellow;
import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.component.shape.Rectangle;

class PointFactoryImpl implements PointFactory {

    private ShapeProvider shapeProvider;
    private ColorFactory colorFactory;
    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int RADIUS = 6;

    public PointFactoryImpl(ShapeProvider shapeProvider, ColorFactory colorFactory) {
        this.shapeProvider = shapeProvider;
        this.colorFactory = colorFactory;
    }

    @Override
    public GamePoint createNormalPoint() {
        Rectangle rectangle = shapeProvider.rectangleBuilder().with(WIDTH, HEIGHT).build();

        SmallPoint smallPoint = new SmallPoint(rectangle);
        smallPoint.setBackground(colorFactory.yellow());

        return smallPoint;
    }

    @Override
    public GamePoint createBigPoint() {
        Arc arc = shapeProvider.arcBuilder().radius(RADIUS).build();

        BigPoint bigPoint = new BigPoint(RADIUS, arc);
        bigPoint.setBackground(colorFactory.yellow());

        return bigPoint;
    }
}
