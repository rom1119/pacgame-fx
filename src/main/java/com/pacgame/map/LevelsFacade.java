package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.map.levels.FirstLevel;
import com.pacgame.map.maps.MapFirst;

public class LevelsFacade {

    private Populator populator;

    public void changeToFirstlevel(Layer box, PointFactory pointFactory)
    {
        depopulatePreviousLevel();
        FirstLevel.Builder builder = new FirstLevel.Builder();
        Level level = builder
                .build();
        populator = new PointPopulator(level, box, pointFactory);
        populator.populate(level.getAllPoints());
    }

    private void depopulatePreviousLevel() {
        if (populator == null) {
            return;
        }

        populator.depopulate();
    }
}
