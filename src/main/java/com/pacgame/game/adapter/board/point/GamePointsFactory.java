package com.pacgame.game.adapter.board.point;

import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.gameElement.standElement.SmallPoint;

import java.util.List;
import java.util.stream.Collectors;

public class GamePointsFactory {
    public List<IPoint> getAllPoints(List<GamePoint> gamePoints) {
        return gamePoints.stream().map(el -> {
            if (el instanceof SmallPoint) {
                return createNormalPoint((SmallPoint) el);
            } else if (el instanceof com.pacgame.gameElement.standElement.BigPoint) {
                return createBigPoint((com.pacgame.gameElement.standElement.BigPoint) el);
            }

            return null;
        }).collect(Collectors.toList());
    }

    private NormalPoint createNormalPoint(SmallPoint point)
    {
        return new NormalPoint(point);
    }

    private BigPoint createBigPoint(com.pacgame.gameElement.standElement.BigPoint point)
    {
        return new BigPoint(point);
    }
}
