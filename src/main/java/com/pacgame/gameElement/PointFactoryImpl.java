package com.pacgame.gameElement;

import com.pacgame.gameElement.standElement.BigPoint;
import com.pacgame.gameElement.standElement.SmallPoint;
import com.pacgame.provider.IShapeProvider;

class PointFactoryImpl implements PointFactory {

    private IShapeProvider shapeProvider;

    public PointFactoryImpl(IShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    @Override
    public StandComponent createNormalPoint() {
        shapeProvider.Builder()
        return new SmallPoint();
    }

    @Override
    public StandComponent createBigPoint() {
        return new BigPoint(, );
    }
}
