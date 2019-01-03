package com.pacgame.game.adapter.board.movement;

import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.MovePointsCreator2D;

import java.util.*;

public class MapPointsCreator implements MovePointsCreator2D {
    
    private List<MovePoint2DAdapter> movePoints = new ArrayList<>();
    
    @Override
    public MovePoint2D getFromPosition(int x, int y) {
        return getMovePointByCoordinates(x, y);
    }

    @Override
    public void createListMovePoints(Collection<?> collection) {
        Map<String, MapPointAdapter> castCollection = ((Map<String, MapPointAdapter>) collection);

        castCollection.forEach((key, val) -> {
            MovePoint2DAdapter newEl = null;
            if (!existPointWithCoordinates(val.getX(), val.getY())) {
                newEl = createMovePoint((MapPointAdapter) val);
            }

            // left
            if (val.getLeft() != null) {
                MovePoint2D newElLeft = null;
                if (!existPointWithCoordinates(val.getLeft().getX(), val.getLeft().getY())) {
                    newElLeft = createMovePoint((MapPointAdapter) val.getLeft());
                } else {
                    newElLeft = getMovePointByCoordinates(val.getLeft().getX(), val.getLeft().getY());
                }

                newEl.setLeft(newElLeft);
            }

            // right
            if (val.getRight() != null) {
                MovePoint2D newElRight = null;
                if (!existPointWithCoordinates(val.getRight().getX(), val.getRight().getY())) {
                    newElRight = createMovePoint((MapPointAdapter) val.getRight());
                } else {
                    newElRight = getMovePointByCoordinates(val.getRight().getX(), val.getRight().getY());
                }

                newEl.setRight(newElRight);
            }

            // up
            if (val.getUp() != null) {
                MovePoint2D newElUp = null;
                if (!existPointWithCoordinates(val.getUp().getX(), val.getUp().getY())) {
                    newElUp = createMovePoint((MapPointAdapter) val.getUp());
                } else {
                    newElUp = getMovePointByCoordinates(val.getUp().getX(), val.getUp().getY());
                }

                newEl.setUp(newElUp);
            }


            // down
            if (val.getDown() != null) {
                MovePoint2D newElDown = null;
                if (!existPointWithCoordinates(val.getDown().getX(), val.getDown().getY())) {
                    newElDown = createMovePoint((MapPointAdapter) val.getDown());
                } else {
                    newElDown = getMovePointByCoordinates(val.getDown().getX(), val.getDown().getY());
                }

                newEl.setDown(newElDown);
            }





        });
    }

    private MovePoint2D getMovePointByCoordinates(int x, int y) {

        return movePoints.stream().filter(el -> el.getX() == x && el.getY() == y).findAny().get();
    }

    private boolean existPointWithCoordinates(int x, int y) {
        return movePoints.stream().anyMatch(el -> el.getX() == x && el.getY() == y);
    }

    private MovePoint2DAdapter createMovePoint(MapPointAdapter mapPointAdapter)
    {

        MovePoint2DAdapter movePoint2D = new MovePoint2DAdapter(mapPointAdapter.getX(), mapPointAdapter.getY());

        movePoints.add(movePoint2D);

        return movePoint2D;
    }

}
