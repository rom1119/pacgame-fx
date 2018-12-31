package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.map.point.MapPoint;

public abstract class Level {

    protected ILevelType levelType;
    protected Map mapInstance;
    protected PointPopulator populator;
    protected LevelMapPath levelMapPath;

    protected Level() {
    }


    public java.util.Map<String, MapPoint> getAllMapPoints() {
        return levelMapPath.getAllPoints();
    }

    public void populatePoints()
    {
        populator.populate(this.getAllMapPoints());
    }

    public void setPopulator(PointPopulator populator) {
        this.populator = populator;
    }

    public void setRootLayer(Layer layer) {
        this.mapInstance.setRootLayer(layer);
    }

    public Layer getRootLayer() {
        return mapInstance.getRootLayer();
    }
}
