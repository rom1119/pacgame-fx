package com.pacgame.game.adapter.board.finder;

import com.pacgame.finder.*;
import com.pacgame.finder.impl.pointToPoint.FinderPointToPoint;
import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.level.IMapPoint;

import java.util.ArrayList;
import java.util.List;

public class FinderAdapter implements Finder {

    private FinderPointToPoint providedObject;

    public void init(Moveable gameElement) {

        this.providedObject = new FinderPointToPoint(new FinderObject2D() {

            private Moveable el = gameElement;
            @Override
            public void moveTo(FindPoint2D point) {

                if (isUpPoint((FindPoint2DAdapter) point, (MapPointAdapter) el.getCurrentPoint())) {
//                    System.out.println("up");
                    el.moveUp();
                } else if (isDownPoint((FindPoint2DAdapter) point, (MapPointAdapter) el.getCurrentPoint())) {
//                    System.out.println("down");
                    el.moveDown();
                } else if (isLeftPoint((FindPoint2DAdapter) point, (MapPointAdapter) el.getCurrentPoint())) {
//                    System.out.println("left");
                    el.moveLeft();
                } else if (isRightPoint((FindPoint2DAdapter) point, (MapPointAdapter) el.getCurrentPoint())) {
//                    System.out.println("right");
                    el.moveRight();
                }
            }


            @Override
            public List<FindPoint2D> getAvailablePoints() {
                return createAvailablePointsFromGameElement((MapPointAdapter) el.getCurrentPoint());
            }
        });
    }

    @Override
    public void find(ObjectToFind objectToFind) {
        providedObject.find(objectToFind);
    }

    @Override
    public void addRule(FinderRule rule) {
        providedObject.addRule(rule);
    }

    @Override
    public void removeRule(FinderRule rule) {
        providedObject.removeRule(rule);
    }

    private List<FindPoint2D> createAvailablePointsFromGameElement(MapPointAdapter currentMapPointFinderElement)
    {
        List<FindPoint2D> newList = new ArrayList<>();

        if (currentMapPointFinderElement != null) {


            FindPoint2DAdapter up = createPoint((MapPointAdapter) currentMapPointFinderElement.getUp());
            FindPoint2DAdapter down = createPoint((MapPointAdapter) currentMapPointFinderElement.getDown());
            FindPoint2DAdapter left = createPoint((MapPointAdapter) currentMapPointFinderElement.getLeft());
            FindPoint2DAdapter right = createPoint((MapPointAdapter) currentMapPointFinderElement.getRight());
//            System.out.println(up);
//            System.out.println(down);
//            System.out.println(left);
//            System.out.println(right);
            if (up != null) {
                newList.add(up);
            }

            if (down != null) {
                newList.add(down);
            }

            if (left != null) {
                newList.add(left);
            }

            if (right != null) {
                newList.add(right);
            }
        }

        return newList;
    }

    private FindPoint2DAdapter createPoint(MapPointAdapter el) {
        if (el != null) {
            return new FindPoint2DAdapter(el);
        }

        return null;
    }

    private boolean isLeftPoint(FindPoint2DAdapter point, MapPointAdapter currentMapPointFinderElement)
    {
        if (currentMapPointFinderElement.getLeft() == null) {
            return false;
        }

        if (point.getX() == currentMapPointFinderElement.getLeft().getX() && point.getY() == currentMapPointFinderElement.getLeft().getY()) {
            return true;
        }

        return false;
    }

    private boolean isRightPoint(FindPoint2DAdapter point, MapPointAdapter currentMapPointFinderElement)
    {
        if (currentMapPointFinderElement.getRight() == null) {
            return false;
        }

        if (point.getX() == currentMapPointFinderElement.getRight().getX() && point.getY() == currentMapPointFinderElement.getRight().getY()) {
            return true;
        }

        return false;
    }

    private boolean isUpPoint(FindPoint2DAdapter point, MapPointAdapter currentMapPointFinderElement)
    {
        if (currentMapPointFinderElement.getUp() == null) {
            return false;
        }

        if (point.getX() == currentMapPointFinderElement.getUp().getX() && point.getY() == currentMapPointFinderElement.getUp().getY()) {
            return true;
        }

        return false;
    }

    private boolean isDownPoint(FindPoint2DAdapter point, MapPointAdapter currentMapPointFinderElement)
    {
        if (currentMapPointFinderElement.getDown() == null) {
            return false;
        }

        if (point.getX() == currentMapPointFinderElement.getDown().getX() && point.getY() == currentMapPointFinderElement.getDown().getY()) {
            return true;
        }

        return false;
    }
}
