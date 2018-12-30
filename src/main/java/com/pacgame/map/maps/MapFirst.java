package com.pacgame.map.maps;

import com.pacgame.color.ColorFactory;
import com.pacgame.map.Map;

public class MapFirst extends Map {

    private final String INITIAL_IMG_PATH = "./map/map_first.png";

    public MapFirst(ColorFactory colorFactory) {
        super(colorFactory);
        setImgUrl(INITIAL_IMG_PATH);
    }

    @Override
    public String getInitialBackgroundUrl() {
        return INITIAL_IMG_PATH;
    }
}
