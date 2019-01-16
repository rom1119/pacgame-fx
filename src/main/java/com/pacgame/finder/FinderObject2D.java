package com.pacgame.finder;

import java.util.List;

public interface FinderObject2D extends FinderObject {
    void moveTo(FindPoint2D point);

    List<FindPoint2D> getAvailablePoints();
}
