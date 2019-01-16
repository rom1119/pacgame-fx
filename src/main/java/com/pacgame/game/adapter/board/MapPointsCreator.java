package com.pacgame.game.adapter.board;

import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.map.point.MapPoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MapPointsCreator {

    private List<IMapPoint> mapPoints = new ArrayList<>();
    public IMapPoint getFromPosition(int x, int y) {
        return getMovePointByCoordinates(x, y);
    }

    public List<IMapPoint> getAllPoints()
    {
        return mapPoints;
    }

    public void createListMovePoints(Map collection) {
        Map<String, MapPoint> castCollection = ((Map<String, MapPoint>) collection);

        castCollection.forEach((key, val) -> {
            if (val == null) {
                return;
            }
            MapPointAdapter newEl = null;
            if (!existPointWithCoordinates(val.getX(), val.getY())) {
                newEl = createMovePoint( val);
            } else {
                newEl = (MapPointAdapter) getMovePointByCoordinates(val.getX(), val.getY());
            }


            if (val.isDoor()) {
                newEl.setDoor(true);
            }

            // left
            if (val.getLeftPoint() != null) {
                IMapPoint newElLeft = null;
                if (!existPointWithCoordinates(val.getLeftPoint().getX(), val.getLeftPoint().getY())) {
                    newElLeft = createMovePoint((MapPoint) val.getLeftPoint());
                } else {
                    newElLeft = getMovePointByCoordinates(val.getLeftPoint().getX(), val.getLeftPoint().getY());
                }

                newEl.setLeft(newElLeft);
            }

            // right
            if (val.getRightPoint() != null) {
                IMapPoint newElRight = null;
                if (!existPointWithCoordinates(val.getRightPoint().getX(), val.getRightPoint().getY())) {
                    newElRight = createMovePoint((MapPoint) val.getRightPoint());
                } else {
                    newElRight = getMovePointByCoordinates(val.getRightPoint().getX(), val.getRightPoint().getY());
                }
                newEl.setRight(newElRight);
            }

            // up
            if (val.getUpPoint() != null) {
                IMapPoint newElUp = null;
                if (!existPointWithCoordinates(val.getUpPoint().getX(), val.getUpPoint().getY())) {
                    newElUp = createMovePoint((MapPoint) val.getUpPoint());
                } else {
                    newElUp = getMovePointByCoordinates(val.getUpPoint().getX(), val.getUpPoint().getY());
                }

                newEl.setUp(newElUp);
            }


            // down
            if (val.getDownPoint() != null) {
                IMapPoint newElDown = null;
                if (!existPointWithCoordinates(val.getDownPoint().getX(), val.getDownPoint().getY())) {
                    newElDown = createMovePoint((MapPoint) val.getDownPoint());
                } else {
                    newElDown = getMovePointByCoordinates(val.getDownPoint().getX(), val.getDownPoint().getY());
                }

                newEl.setDown(newElDown);
            }


        });
    }

    private IMapPoint getMovePointByCoordinates(int x, int y) {

        return mapPoints.stream().filter(el -> el.getX() == x && el.getY() == y).findAny().orElseGet(() -> null);
    }

    private boolean existPointWithCoordinates(int x, int y) {
        return mapPoints.stream().anyMatch(el -> el.getX() == x && el.getY() == y);
    }

    private MapPointAdapter createMovePoint(MapPoint mapPointAdapter)
    {

        MapPointAdapter movePoint2D = new MapPointAdapter(mapPointAdapter.getX(), mapPointAdapter.getY());
        movePoint2D.setName(mapPointAdapter.getName());

        mapPoints.add(movePoint2D);

        return movePoint2D;
    }
}
