package com.pacgame.map;

import com.pacgame.map.point.MapPoint;
import org.apache.commons.collections.BidiMap;

import java.util.Map;

public abstract class LevelMapPath {

    public abstract Map<String, MapPoint> getAllPoints();
}
