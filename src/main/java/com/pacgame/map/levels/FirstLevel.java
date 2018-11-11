package com.pacgame.map.levels;

import com.pacgame.map.Level;
import com.pacgame.map.Map;
import com.pacgame.map.maps.MapFirst;

public class FirstLevel extends Level {

    private FirstLevel(Builder builder) {
        if (builder == null) {
            return;
        }

        this.levelMapPath = builder.mapPath;
        this.mapInstance = builder.mapInstance;
    }

    public static class Builder {

        private Map mapInstance = new MapFirst();
        private LevelMapPath mapPath = new FirstLevelMapPath();



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

        public Level build()
        {
            return new FirstLevel(this);
        }


    }
}
