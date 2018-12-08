package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.gameElement.PointFactory;
import org.apache.commons.collections.BidiMap;

class PointPopulator extends Populator {

    private Level level;
    private Layer box;
    private PointFactory pointFactory;

    public PointPopulator(Level level, Layer box, PointFactory pointFactory) {
        this.level = level;
        this.box = box;
        this.pointFactory = pointFactory;
        level.setRootLayer(box);
    }

    @Override
    void depopulate()
    {
//        allPoints.stream().forEach(el -> {
//            root.getChildren().remove(el.getCollider());
//            root.getChildren().remove(el.getIcon());
//        });
    }

    @Override
    void populate(BidiMap allPoints){

        int i = 0;

        for (Object point : allPoints.keySet()) {
//
            String key = (String) point;
//            MapPoint mapPoint = (MapPoint) arrayOfPoints.get(key);
//
//            if (mapPoint == null) {
//                continue;
//            }
//
//            if (key.equals("e5") || key.equals("e6") || key.equals("e5A") ) {
//                continue;
//            }
//
//            NormalPoint normalPoint;
//            if (key.charAt(0) == 'h' ||
//                    key.charAt(0) == 'i' ||
//                    key.charAt(0) == 'j' ||
//                    key.charAt(0) == 'd' ||
//                    key.charAt(0) == 'b' ||
//                    key.charAt(0) == 'c' ||
//                    key.charAt(0) == 'e'
//                    ) {
//                normalPoint = createNormalPoint((mapPoint.getX() / 2), (mapPoint.getY() / 2) - 3);
//
//            } else {
//                normalPoint = createNormalPoint((mapPoint.getX() / 2), (mapPoint.getY() / 2));
//
//            }
//
//            layer.addChildren(App.indexForMaze - 1, normalPoint.getCollider());
//            root.getChildren().add(App.indexForMaze - 1, normalPoint.getIcon());
//
//            tryAddNormalPointInterX(mapPoint, root, key);
//            tryAddNormalPointInterY(mapPoint, root, key);

            i++;


        }
    }
}
