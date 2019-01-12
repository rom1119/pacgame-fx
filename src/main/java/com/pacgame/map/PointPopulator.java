package com.pacgame.map;

import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.map.point.MapPoint;
import org.apache.commons.collections.BidiMap;

import java.util.List;
import java.util.Map;

public abstract class PointPopulator {

    public abstract void setLevel(Level level);
    public abstract List<GamePoint> populate(Map<String, MapPoint> allPoints);
    public abstract List<GamePoint> getAllPoints();
    public abstract void depopulate();
}
