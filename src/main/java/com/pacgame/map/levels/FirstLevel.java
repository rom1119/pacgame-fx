package com.pacgame.map.levels;

import com.pacgame.map.IMap;
import com.pacgame.map.Level;
import com.pacgame.map.maps.MapFirst;

public class FirstLevel extends Level {

    private FirstLevel() {
    }

    private FirstLevel(Builder builder) {
        if (builder == null) {
            return;
        }

        this.mapInstance = builder.mapInstance;
    }

    public static class Builder {

        private IMap mapInstance;

        public Builder withMap(String imgUrl)
        {
            this.mapInstance = new MapFirst(imgUrl);

            return this;
        }

        public Level build()
        {
            return new FirstLevel(this);
        }


    }
}
