package com.pacgame.map.levels;

import com.pacgame.Layer;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.map.Level;
import com.pacgame.map.PointPopulator;
import com.pacgame.map.point.MapPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FirstLevelPopulator extends PointPopulator {

    private Level level;
    private PointFactory pointFactory;
    private List<GamePoint> gamePoints;

    public FirstLevelPopulator(PointFactory pointFactory) {
        this.pointFactory = pointFactory;
        this.gamePoints = new ArrayList<>();
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void depopulate()
    {
//        gamePoints.stream().forEach(el -> {
//            root.getChildren().remove(el.getCollider());
//            root.getChildren().remove(el.getIcon());
//        });
    }

    @Override
    public List<GamePoint> populate(Map<String, MapPoint> allPoints){

        int i = 0;

        for (Map.Entry<String, MapPoint> point : allPoints.entrySet()) {
//
            String key = point.getKey();
            MapPoint mapPoint = allPoints.get(key);

            if (mapPoint == null) {
                continue;
            }

            if (key.equals("e5") || key.equals("e6") || key.equals("e5A") ) {
                continue;
            }

            GamePoint normalPoint;
            if (key.charAt(0) == 'h' ||
                    key.charAt(0) == 'i' ||
                    key.charAt(0) == 'j' ||
                    key.charAt(0) == 'd' ||
                    key.charAt(0) == 'b' ||
                    key.charAt(0) == 'c' ||
                    key.charAt(0) == 'e'
                    ) {
                normalPoint = createNormalPoint((mapPoint.getX() / 2), (mapPoint.getY() / 2) - 3);

            } else {
                normalPoint = createNormalPoint((mapPoint.getX() / 2), (mapPoint.getY() / 2));

            }

            level.getRootLayer().addChildren(normalPoint);

            tryAddNormalPointInterX(mapPoint, level.getRootLayer(), key);
            tryAddNormalPointInterY(mapPoint, level.getRootLayer(), key);

            i++;


        }

        return gamePoints;



    }

    private GamePoint createNormalPoint(int x, int y)
    {
        GamePoint point = pointFactory.createNormalPoint();
        point.setX(x );
        point.setY(y);

        gamePoints.add(point);

        return point;
    }

    private GamePoint createBigPoint(int x, int y)
    {
        GamePoint point = pointFactory.createBigPoint();
        point.setX(x );
        point.setY(y );

        gamePoints.add(point);

        return point;
    }

    private boolean tryAddNormalPointInterX(MapPoint mapPoint, Layer root, String key)
    {

        if (mapPoint.getRightPoint() == null) {
            return false;
        }

        if (key.equals("h5")) {
            return false;
        }

        double diffY = mapPoint.getRightPoint().getX() - mapPoint.getX();

        if (mapPoint.getRightPoint() != null && diffY > 180) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 7);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 100) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 4);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 90) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 3);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 40) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 1);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        }


        return true;

    }

    private boolean tryAddNormalPointInterY(MapPoint mapPoint, Layer root, String key)
    {

        if (mapPoint.getDownPoint() == null) {
            return false;
        }

        double diffY = mapPoint.getDownPoint().getY() - mapPoint.getY();

        if (mapPoint.getDownPoint() != null && diffY > 80) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 3);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 60) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 2);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 35) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 1);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 30) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 1);
//            SmallPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        }


        return true;

    }

    private void addRightPoints(String key, MapPoint mapPoint, Layer root, int amountPoints)
    {
        GamePoint gamePoint;

        int i = 1;

        if (key.charAt(0) == 'h' ||
                key.charAt(0) == 'i' ||
                key.charAt(0) == 'j' ||
                key.charAt(0) == 'd' ||
                key.charAt(0) == 'b' ||
                key.charAt(0) == 'c' ||
                key.charAt(0) == 'e'
                ) {

            while (i <= amountPoints) {
                gamePoint = createNormalPoint(((mapPoint.getX() + (25 * i)) / 2), (mapPoint.getY() / 2) - 3);
                root.addChildren(gamePoint);
                i++;
            }


        } else {

            while (i <= amountPoints) {
                gamePoint = createNormalPoint(((mapPoint.getX() + (25 * i)) / 2), (mapPoint.getY() / 2));
                root.addChildren(gamePoint);

                i++;
            }

        }
    }

    private void addDownPoints(String key, MapPoint mapPoint, Layer root, int amountPoints)
    {
        GamePoint morePoint;

        int i = 1;

        if (key.equals("d5A")) {
            return;
        }

        if (key.charAt(0) == 'h' ||
                key.charAt(0) == 'i' ||
                key.charAt(0) == 'j' ||
                key.charAt(0) == 'd' ||
                key.charAt(0) == 'b' ||
                key.charAt(0) == 'c' ||
                key.charAt(0) == 'e'
                ) {

            while (i <= amountPoints) {

                if (canAddBigPoint(i, key)) {
                    morePoint = createBigPoint(((mapPoint.getX()) / 2), ((mapPoint.getY()+ (22 * i)) / 2) - 3);

                } else {
                    morePoint = createNormalPoint(((mapPoint.getX()) / 2), ((mapPoint.getY()+ (22 * i)) / 2) - 3);
                }

                root.addChildren(morePoint);
                i++;
            }


        } else {

            while (i <= amountPoints) {
                if (canAddBigPoint(i, key)) {
                    morePoint = createBigPoint(((mapPoint.getX()) / 2), ((mapPoint.getY() + (22 * i)) / 2));
                } else {
                    morePoint = createNormalPoint(((mapPoint.getX()) / 2), ((mapPoint.getY() + (22 * i)) / 2));
                }
                root.addChildren(morePoint);
                i++;
            }

        }
    }

    private boolean canAddBigPoint(int i, String key)
    {
        return (
                (i == 1) && key.equals("a1")) ||
                ((i == 1) && key.equals("a10") ||
                        ((i == 1) && key.equals("i1") ||
                                ((i == 1) && key.equals("i10")
                                )));
    }
}
