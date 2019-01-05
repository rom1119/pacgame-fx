package com.pacgame.game.adapter.board.movement;

import com.pacgame.game.IView;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.provider.animation.AnimationBuilder;

import java.util.List;

public class MovementFactory {

    private AnimationBuilder animationBuilder;
    private MovePointsCreatorAdapter movePointsCreator;


    public MovementFactory(AnimationBuilder animationBuilder, MovePointsCreatorAdapter movePointsCreator) {
        this.animationBuilder = animationBuilder;
        this.movePointsCreator = movePointsCreator;
    }

    public void createMovePoints(List<IMapPoint> mapPoints)
    {
        movePointsCreator.createListMovePoints(mapPoints);
    }


    public IMovement createMovementSystem(IMapPoint initPoint, IView viewAdapter){
        Movement2DAdapter movement2DAdapter = new Movement2DAdapter(animationBuilder, movePointsCreator);
        movement2DAdapter.init(initPoint, viewAdapter);

        return movement2DAdapter;
    }
}
