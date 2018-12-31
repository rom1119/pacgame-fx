package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.color.ColorFactory;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.map.levels.FirstLevel;
import com.pacgame.map.maps.MapFirst;

public class LevelsFacade {

    private PointPopulator populator;
    protected ColorFactory colorFactory;

    public LevelsFacade(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    public Level changeToFirstLevel(Layer box, PointFactory pointFactory)
    {
        depopulatePreviousLevel();
        FirstLevel.Builder builder = new FirstLevel.Builder();
        Level level = builder
                .withMap(new MapFirst(colorFactory))
                .withRootLayer(box)
                .withPointPopulator(pointFactory)
                .build();

        return level;
    }

    private void depopulatePreviousLevel() {
        if (populator == null) {
            return;
        }

        populator.depopulate();
    }
}
