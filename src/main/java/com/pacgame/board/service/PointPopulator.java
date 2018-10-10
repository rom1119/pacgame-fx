package com.pacgame.board.service;

import com.pacgame.App;
import com.pacgame.board.model.MapPoint;
import com.pacgame.board.model.point.BigPoint;
import com.pacgame.board.model.point.NormalPoint;
import com.pacgame.Point;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import org.apache.commons.collections.BidiMap;

import javafx.scene.Group;

public class PointPopulator {

//    private static int[] bigPoints = {
//            new Point2D()
//    }

    private static final int size = 6;

    protected static PointFactory pointFactory;
    public static ObservableList<Point> allPoints;
    static {
        allPoints = FXCollections.observableArrayList();
    }

    public static void depopulate(Group root)
    {
        allPoints.stream().forEach(el -> {
            root.getChildren().remove(el.getCollider());
            root.getChildren().remove(el.getIcon());
        });
    }

    public static ObservableList<Point> populate(BidiMap arrayOfpoints, Group root)
    {
        pointFactory = new PointFactory();

        ObservableList<Node> children = root.getChildren();
        int i = 0;

        for (Object point : arrayOfpoints.keySet()) {
//
            String key = (String) point;
            MapPoint mapPoint = (MapPoint) arrayOfpoints.get(key);

            if (mapPoint == null) {
                continue;
            }

            if (key.equals("e5") || key.equals("e6") || key.equals("e5A") ) {
                continue;
            }

            NormalPoint normalPoint;
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

            root.getChildren().add(App.indexForMaze - 1, normalPoint.getCollider());
            root.getChildren().add(App.indexForMaze - 1, normalPoint.getIcon());

            tryAddNormalPointInterX(mapPoint, root, key);
            tryAddNormalPointInterY(mapPoint, root, key);

            i++;


        }
        return allPoints;
//        System.out.println(root.getChildren().size());

    }

    private static NormalPoint createNormalPoint(double x, double y)
    {
        NormalPoint point = new NormalPoint(new Point2D(x, y), size);

        allPoints.add(point);

        return point;
    }

    private static BigPoint createBigPoint(double x, double y)
    {
        BigPoint point = new BigPoint(new Point2D(x - (size / 3), y - (size / 3)), size * 2);

        allPoints.add(point);

        return point;
    }

    private static boolean tryAddNormalPointInterX(MapPoint mapPoint, Group root, String key)
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
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 100) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 4);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 90) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 3);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getRightPoint() != null && diffY > 40) {
//            System.out.println(diffY);
            addRightPoints(key, mapPoint, root, 1);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        }


        return true;

    }

    private static boolean tryAddNormalPointInterY(MapPoint mapPoint, Group root, String key)
    {

        if (mapPoint.getDownPoint() == null) {
            return false;
        }

        double diffY = mapPoint.getDownPoint().getY() - mapPoint.getY();

        if (mapPoint.getDownPoint() != null && diffY > 80) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 3);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 60) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 2);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 35) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 1);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        } else if (mapPoint.getDownPoint() != null && diffY > 30) {
//            System.out.println(diffY);
            addDownPoints(key, mapPoint, root, 1);
//            NormalPoint morePoint = createNormalPoint(((mapPoint.getX() + 20) / 2), ((mapPoint.getY() ) / 2));

        }


        return true;

    }

    private static void addRightPoints(String key, MapPoint mapPoint, Group root, int amountPoints)
    {
        NormalPoint morePoint;

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
                morePoint = createNormalPoint(((mapPoint.getX() + (25 * i)) / 2), (mapPoint.getY() / 2) - 3);
                root.getChildren().add(App.indexForMaze - 1, morePoint.getCollider());
                root.getChildren().add(App.indexForMaze - 1, morePoint.getIcon());
                i++;
            }


        } else {

            while (i <= amountPoints) {
                morePoint = createNormalPoint(((mapPoint.getX() + (25 * i)) / 2), (mapPoint.getY() / 2));
                root.getChildren().add(App.indexForMaze - 1, morePoint.getCollider());
                root.getChildren().add(App.indexForMaze - 1, morePoint.getIcon());

                i++;
            }

        }
    }

    private static void addDownPoints(String key, MapPoint mapPoint, Group root, int amountPoints)
    {
        Point morePoint;

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

                root.getChildren().add(App.indexForMaze - 1, morePoint.getCollider());
                root.getChildren().add(App.indexForMaze - 1, morePoint.getIcon());
                i++;
            }


        } else {

            while (i <= amountPoints) {
                if (canAddBigPoint(i, key)) {
                    morePoint = createBigPoint(((mapPoint.getX()) / 2), ((mapPoint.getY() + (22 * i)) / 2));
                } else {
                    morePoint = createNormalPoint(((mapPoint.getX()) / 2), ((mapPoint.getY() + (22 * i)) / 2));
                }
                root.getChildren().add(App.indexForMaze - 1, morePoint.getCollider());
                root.getChildren().add(App.indexForMaze - 1, morePoint.getIcon());
                i++;
            }

        }
    }

    private static boolean canAddBigPoint(int i, String key)
    {
        return (
                (i == 1) && key.equals("a1")) ||
                ((i == 1) && key.equals("a10") ||
                ((i == 1) && key.equals("i1") ||
                ((i == 1) && key.equals("i10")
                )));
    }
}
