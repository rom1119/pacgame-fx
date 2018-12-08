package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.map.levels.LevelMapPath;
import org.apache.commons.collections.BidiMap;

public abstract class Level {

    protected ILevelType levelType;
    protected Map mapInstance;
    protected Layer rootLayer;


    protected LevelMapPath levelMapPath;

    protected Level() {
    }


    public BidiMap getAllPoints() {
        return levelMapPath.getAllPoints();
    }


    void setRootLayer(Layer layer) {
        this.rootLayer = layer;
    }

    Layer getRootLayer() {
        return rootLayer;
    }
}
