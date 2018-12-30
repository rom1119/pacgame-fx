package com.pacgame.map.levels;

import com.pacgame.Layer;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.map.Level;
import com.pacgame.map.LevelMapPath;
import com.pacgame.map.Map;
import com.pacgame.map.PointPopulator;
import com.pacgame.map.maps.MapFirst;

public class FirstLevel extends Level {

    private FirstLevel(Builder builder) {
        if (builder == null) {
            return;
        }

        this.levelMapPath = builder.mapPath;
        this.mapInstance = builder.mapInstance;
        this.populator = builder.pointPopulator;
        this.mapInstance.setRootLayer(builder.rootLayer);
        this.mapInstance.setImgUrl(this.mapInstance.getInitialBackgroundUrl());
    }

    public static class Builder {

        private Map mapInstance ;
        private LevelMapPath mapPath = new FirstLevelMapPath();
        private PointPopulator pointPopulator ;
        protected Layer rootLayer;


        public Builder withMap(Map map)
        {
            this.mapInstance = map;

            return this;
        }

        public Builder withMapPath(LevelMapPath levelMapPath)
        {
            this.mapPath = levelMapPath;

            return this;
        }

        public Builder withRootLayer(Layer box)
        {
            this.rootLayer = box;

            return this;
        }

        public Level build()
        {
            if (rootLayer == null) {
                throw new NullPointerException("Root layer can not be null");
            }

            if (pointPopulator == null) {
                throw new NullPointerException("Point populator can not be null");
            }

            FirstLevel firstLevel = new FirstLevel(this);
            firstLevel.setPopulator(pointPopulator);
            pointPopulator.setLevel(firstLevel);

            return firstLevel;
        }


        public Builder withPointPopulator(PointFactory pointFactory) {
            pointPopulator = new FirstLevelPopulator(pointFactory);
            return this;
        }
    }
}
